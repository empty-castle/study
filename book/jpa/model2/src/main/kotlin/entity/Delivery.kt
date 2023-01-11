package entity

import javax.persistence.*

@Entity
class Delivery: BaseEntity() {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    var id: Long? = null

    @OneToOne(mappedBy = "delivery")
    var order: Order? = null

    @Embedded
    var address: Address? = null

    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus? = null
}
