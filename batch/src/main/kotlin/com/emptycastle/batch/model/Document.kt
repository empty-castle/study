package com.emptycastle.batch.model

import java.time.LocalDate

data class Document(
    val title: String,
    val writer: String,
    val note: String,
    val createData: LocalDate,
)