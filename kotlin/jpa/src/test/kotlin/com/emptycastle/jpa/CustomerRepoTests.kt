package com.emptycastle.jpa

import com.emptycastle.jpa.repository.CustomerRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
class CustomerRepoTests @Autowired constructor(private val customerRepo: CustomerRepo) {

    @Test
    fun test() {

        Assertions.assertTrue(customerRepo.findAllBy().isNotEmpty())
        Assertions.assertTrue(customerRepo.findAllByNameContainingAndAddress(null, null).isNotEmpty())
    }
}