package entity.manyToMany.complexTwoWay

import javax.persistence.*

@Entity
open class Member {

    @Id
    @Column(name = "MEMBER_ID")
    open var id: String? = null

    open var username: String? = null

    @OneToMany(mappedBy = "member")
    open var memberProducts: MutableList<MemberProduct> = mutableListOf()
}