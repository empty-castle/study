package entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "ORDER_ITEM")
class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    val item: Item? = null

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    var order: Order? = null

    var orderPrice: Int? = null

    var count: Int? = null
}