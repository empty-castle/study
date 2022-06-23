package com.emptycastle.jpa

import com.emptycastle.jpa.repository.CustomerRepo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

//@Component
@SpringBootApplication
class JpaApplication

//class JpaApplication (private val customerRepo: CustomerRepo) {
//	init {
//		println(customerRepo.findAllBy())
//	}
//}

fun main(args: Array<String>) {
	runApplication<JpaApplication>(*args)
}