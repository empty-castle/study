package com.emptycastle.batch.model

import com.emptycastle.batch.service.adapter.LocalDateTimeAdapter
import java.time.LocalDateTime
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@XmlRootElement(name = "transactionRecord")
data class Transaction(
    var username: String = "",
    var userId: Int = 0,
    var age: Int = 0,
    var postCode: String = "",
    @XmlJavaTypeAdapter(LocalDateTimeAdapter::class)
    var transactionDate: LocalDateTime = LocalDateTime.now(),
    var amount: Double = 0.0,
)