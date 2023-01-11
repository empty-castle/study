package entity

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member: BaseEntity() {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    var id: Long? = null

    var name: String? = null

    @Embedded
    var address: Address? = null

    @OneToMany(mappedBy = "member")
    var orders: MutableList<Order> = mutableListOf()
}