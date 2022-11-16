package com.emptycastle.batch.service.adapter

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.xml.bind.annotation.adapters.XmlAdapter

class LocalDateTimeAdapter: XmlAdapter<String, LocalDateTime>() {

    companion object {

        private const val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
        val DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
    }

    override fun unmarshal(v: String?): LocalDateTime = LocalDateTime.parse(v, DATE_TIME_FORMATTER)

    override fun marshal(v: LocalDateTime?): String = DATE_TIME_FORMATTER.format(v)
}