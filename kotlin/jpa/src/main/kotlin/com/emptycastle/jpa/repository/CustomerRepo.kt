package com.emptycastle.jpa.repository

import com.emptycastle.jpa.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepo: JpaRepository<CustomerEntity, Long?> {

    fun findAllBy(): List<CustomerEntity>

    @Query("select c from CustomerEntity c where (:name is null or c.name = :name) and (:address is null or c.address = :address)")
    fun findAllByNameContainingAndAddress(@Param("name") name: String?, @Param("address") address: String?): List<CustomerEntity>
}