package com.emptycastle.batch.entity

import java.math.BigDecimal
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "DOCUMENT")
class DocumentEntity (

    @Column(name = "TITLE", nullable = false)
    var title: String = "",

    @Column(name = "WRITER", nullable = false)
    var writer: String = "",

    @Column(name = "NOTE", nullable = true)
    var note: String? = null,

    @Column(name = "CREATE_DATE", nullable = false)
    var createDate: Date = Date(),

    @Column(name = "ESCALATION_DATE", nullable = false)
    var escalationDate: Date = Date(),

) {

    @Id
    @Column(name = "NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: BigDecimal? = null
}
