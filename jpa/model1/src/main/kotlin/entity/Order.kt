package entity

import type.OrderStatus
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    var id: Long? = null

    @Column(name = "MEMBER_ID")
    var memberId: Long? = null

    @Temporal(TemporalType.TIMESTAMP)
    var orderDate: Date? = null

    @Enumerated(EnumType.STRING)
    var status: OrderStatus? = null
}