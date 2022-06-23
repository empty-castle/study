package com.emptycastle.jpa.repository

import com.emptycastle.jpa.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepo: JpaRepository<CustomerEntity, Long?> {

    fun findAllBy(): List<CustomerEntity>
}