package com.emptycastle.batch.tasklets

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus

class TutorialTasklet(private val date: String?): Tasklet {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        log.info(">>> execute Tasklet")
        log.info(">>> $date")
        return RepeatStatus.FINISHED
    }
}