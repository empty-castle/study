package com.emptycastle.jpa.entity

import lombok.Getter
import lombok.Setter
import lombok.ToString
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
open class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    open var id: Long? = null

    @Column(name = "NAME", nullable = false)
    open var name: String? = null

    @Column(name = "ADDRESS")
    open var address: String? = null

    @Column(name = "WEBSITE")
    open var website: String? = null

    @Column(name = "CREDIT_LIMIT", precision = 8, scale = 2)
    open var creditLimit: BigDecimal? = null

    override fun toString(): String {
        return "{id: $id, name: $name, address: $address, website: $website, creditLimit: $creditLimit}"
    }
}