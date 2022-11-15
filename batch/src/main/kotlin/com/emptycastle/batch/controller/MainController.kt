package com.emptycastle.batch.controller

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/batch")
class MainController(
    private val jobLauncher: JobLauncher,
    private val tutorialJob: Job
) {

    @GetMapping("/initiate")
    fun initiateJobLauncher(): String {

        val jobParameter = JobParametersBuilder()
            .addString("date", "20221115")
            .toJobParameters()

        jobLauncher.run(tutorialJob, jobParameter)

        return "GOOD"
    }
}