package entity

import entity.item.Item
import javax.persistence.*

@Entity
@Table(name = "ORDER_ITEM")
class OrderItem: BaseEntity() {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    var item: Item? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    var order: Order? = null

    var orderPrice: Int? = null

    var count: Int? = null
}