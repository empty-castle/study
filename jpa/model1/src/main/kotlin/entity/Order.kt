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

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    var member: Member? = null
        set(value) {
            if (field != null) {
                field!!.orders.remove(this)
            }
            field = value
            field?.orders?.add(this)
        }

    @OneToMany(mappedBy = "order")
    var orderItems: MutableList<OrderItem> = mutableListOf()

    @Temporal(TemporalType.TIMESTAMP)
    var orderDate: Date? = null

    @Enumerated(EnumType.STRING)
    var status: OrderStatus? = null

    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
        orderItem.order = this
    }
}