package com.emptycastle.batch.service

import com.emptycastle.batch.model.Transaction
import org.springframework.batch.item.file.mapping.FieldSetMapper
import org.springframework.batch.item.file.transform.FieldSet
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RecordFieldSetMapper: FieldSetMapper<Transaction> {

    override fun mapFieldSet(fieldSet: FieldSet): Transaction {

        val formatter = DateTimeFormatter.ofPattern("d/M/yyy")
        val transaction = Transaction().apply {
            username = fieldSet.readString("username")
            userId = fieldSet.readInt("userid")
            amount = fieldSet.readDouble(3)
            transactionDate = LocalDate.parse(fieldSet.readString(2), formatter).atStartOfDay()
        }
        return transaction
    }
}