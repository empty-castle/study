package entity

import type.OrderStatus
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
open class Order: BaseEntity() {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    var member: Member? = null
        set(value) {
            if (field != null) {
                field!!.orders.remove(this)
            }
            field = value
            field?.orders?.add(this)
        }

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: MutableList<OrderItem> = mutableListOf()

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "DELIVERY_ID")
    var delivery: Delivery? = null
        set(value) {
            field = value
            value?.order = this
        }

    @Temporal(TemporalType.TIMESTAMP)
    var orderDate: Date? = null

    @Enumerated(EnumType.STRING)
    var status: OrderStatus? = null

    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
        orderItem.order = this
    }
}