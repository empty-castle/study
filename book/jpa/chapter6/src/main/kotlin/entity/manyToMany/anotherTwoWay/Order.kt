package entity.manyToMany.anotherTwoWay

import javax.persistence.*

@Entity
@Table(name = "ORDERS")
open class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    open var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    open var member: Member? = null

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    open var product: Product? = null

    open var orderAmount: Int = 0
}