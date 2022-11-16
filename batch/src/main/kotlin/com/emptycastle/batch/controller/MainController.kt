package com.emptycastle.batch.controller

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/batch")
class MainController(
    private val jobLauncher: JobLauncher,
    private val baeldungJob: Job
) {

    @GetMapping("/initiate")
    fun initiateJobLauncher(): String {

        val confMap = HashMap<String, JobParameter>()
        confMap["time"] = JobParameter(System.currentTimeMillis())
        jobLauncher.run(baeldungJob, JobParameters(confMap))

        return "GOOD"
    }
}