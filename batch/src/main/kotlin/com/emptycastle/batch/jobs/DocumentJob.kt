//package com.emptycastle.batch.jobs
//
//import com.emptycastle.batch.model.Document
//import com.emptycastle.batch.tasklets.TutorialTasklet
//import org.springframework.batch.core.Job
//import org.springframework.batch.core.Step
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
//import org.springframework.batch.core.configuration.annotation.JobScope
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
//import org.springframework.batch.item.xml.StaxEventItemReader
//import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.io.FileSystemResource
//import org.springframework.oxm.xstream.XStreamMarshaller
//import java.time.LocalDate
//
//@Configuration
//class DocumentJob(
//    val jobBuilderFactory: JobBuilderFactory,
//    val stepBuilderFactory: StepBuilderFactory,
//) {
//
//    @Bean
//    fun tutorialJob(): Job = jobBuilderFactory.get("tutorialJob")
//        .start(tutorialStep(null))
//        .build()
//
//    @Bean
//    @JobScope
//    fun tutorialStep(@Value("#{jobParameters[date]}") date: String?): Step = stepBuilderFactory.get("tutorialStep")
//        .tasklet(TutorialTasklet(date))
//        .build()
//
//    @Bean
//    fun documentStoringJob(): Job = jobBuilderFactory.get("documentStoringJob")
//        .start(documentStoringStep())
//        .build()
//
//    @Bean
//    fun documentStoringStep(): Step = stepBuilderFactory.get("documentStoringStep")
//        .chunk<Document, Document>(3)
//        .reader(xmlDocumentReader())
//        .build()
//
//    @Bean
//    fun xmlDocumentReader(): StaxEventItemReader<Document> = StaxEventItemReaderBuilder<Document>()
//        .name("documentReader")
//        .resource(FileSystemResource("../../../xml/cube.xml"))
//        .addFragmentRootElements("document")
//        .unmarshaller(documentMarshaller())
//        .build()
//
//    @Bean
//    fun documentMarshaller(): XStreamMarshaller {
//        val aliases = HashMap<String, Class<out Any>>()
//        aliases["document"] = Document::class.java
//        aliases["title"] = String::class.java
//        aliases["writer"] = String::class.java
//        aliases["note"] = String::class.java
//        aliases["create_date"] = LocalDate::class.java
//        val xStreamMarshaller = XStreamMarshaller()
//        xStreamMarshaller.setAliases(aliases)
//        return xStreamMarshaller
//    }
//}