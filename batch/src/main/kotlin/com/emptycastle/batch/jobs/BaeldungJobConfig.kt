package com.emptycastle.batch.jobs

import com.emptycastle.batch.model.Transaction
import com.emptycastle.batch.service.BaeldungItemProcessor
import com.emptycastle.batch.service.MissingUsernameException
import com.emptycastle.batch.service.NegativeAmountException
import com.emptycastle.batch.service.RecordFieldSetMapper
import org.apache.http.client.config.RequestConfig
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.batch.item.xml.StaxEventItemWriter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.PathResource
import org.springframework.core.io.Resource
import org.springframework.oxm.Marshaller
import org.springframework.oxm.jaxb.Jaxb2Marshaller

@Configuration
class BaeldungJobConfig(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
) {

    val inputCsv = PathResource("C:\\.repo\\study\\batch\\src\\main\\resources\\baeldung\\input.csv")

    @Value("file:batch/src/main/resources/baeldung/output.xml")
    lateinit var outputXml: Resource

    companion object {
        val tokens = arrayOf("username", "userid", "transactiondate", "amount")
        val TWO_SECONDS = 2000
    }

    @Bean
    fun baeldungJob(@Qualifier("baeldungStep") baeldungStep: Step): Job =
        jobBuilderFactory.get("baeldungStep")
            .start(baeldungStep)
            .build()

    @Bean
    @JobScope
    fun baeldungStep(
        @Qualifier("baeldungItemProcessor") processor: ItemProcessor<Transaction, Transaction>,
        writer: ItemWriter<Transaction>,
    ): Step =
        stepBuilderFactory.get("baeldungStep")
            .chunk<Transaction, Transaction>(10)
            .reader(baeldungItemReader(inputCsv))
            .processor(processor)
            .writer(writer)
            .faultTolerant()
            .skipLimit(3)
            .skip(MissingUsernameException::class.java)
            .skip(NegativeAmountException::class.java)
//            .retryLimit(3)
//            .retry(ConnectTimeoutException::class.java)
//            .retry(DeadlockLoserDataAccessException::class.java)
            .build()

    @Bean
    fun closeableHttpClient(): CloseableHttpClient {
        val config = RequestConfig.custom()
            .setConnectTimeout(TWO_SECONDS)
            .build()
        return HttpClientBuilder.create().setDefaultRequestConfig(config).build()
    }

    @Bean
    fun baeldungItemProcessor(): ItemProcessor<Transaction, Transaction> = BaeldungItemProcessor()

    @Bean
    fun baeldungItemWriter(marshaller: Marshaller): ItemWriter<Transaction> =
        StaxEventItemWriter<Transaction>().apply {
            setMarshaller(marshaller)
            rootTagName = "transactionRecord"
            setResource(outputXml)
        }

    @Bean
    fun marshaller(): Marshaller = Jaxb2Marshaller().apply {
        setClassesToBeBound(Transaction::class.java)
    }

    fun baeldungItemReader(inputData: Resource): ItemReader<Transaction> {
        val tokenizer: DelimitedLineTokenizer = DelimitedLineTokenizer().apply {
            setNames(*tokens)
        }
        val lineMapper = DefaultLineMapper<Transaction>().apply {
            setLineTokenizer(tokenizer)
            setFieldSetMapper(RecordFieldSetMapper())
        }
        val reader = FlatFileItemReader<Transaction>().apply {
            setResource(inputData)
            setLinesToSkip(1)
            setLineMapper(lineMapper)
        }
        return reader
    }
}