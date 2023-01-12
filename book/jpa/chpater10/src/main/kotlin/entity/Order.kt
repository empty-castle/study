package entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "ORDERS")
class Order {

    @Id
    var id: Long? = null

    @ManyToOne
    var member: Member? = null

    @ManyToOne
    var product: Product? = null

    var orderAmount: Long? = null
    var city: String? = null
    var street: String? = null
    var zipCode: String? = null
}