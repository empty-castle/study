package com.emptycastle.batch.jobs

import com.emptycastle.batch.tasklets.TutorialTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TutorialConfig(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
) {

    @Bean
    fun tutorialJob(): Job = jobBuilderFactory.get("tutorialJob")
        .start(tutorialStep(null))
        .build()

    @Bean
    @JobScope
    fun tutorialStep(@Value("#{jobParameters[date]}") date: String?): Step = stepBuilderFactory.get("tutorialStep")
        .tasklet(TutorialTasklet(date))
        .build()
}