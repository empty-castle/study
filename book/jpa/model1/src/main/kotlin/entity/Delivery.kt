package entity

import javax.persistence.*

@Entity
class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    var id: Long? = null

    @OneToOne(mappedBy = "delivery")
    var order: Order? = null

    var city: String? = null
    var street: String? = null
    var zipcode: String? = null

    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus? = null
}
