package entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    var id: Long? = null

    var name: String? = null

    var city: String? = null

    var street: String? = null

    var zipcode: String? = null

    @OneToMany(mappedBy = "member")
    var orders: MutableList<Order> = mutableListOf()
}