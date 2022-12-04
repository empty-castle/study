package entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ORDER_ITEM")
class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    var id: Long? = null

    @Column(name = "ITEM_ID")
    var itemId: Long? = null

    @Column(name = "ORDER_ID")
    var orderId: Long? = null

    var orderPrice: Int? = null

    var count: Int? = null
}