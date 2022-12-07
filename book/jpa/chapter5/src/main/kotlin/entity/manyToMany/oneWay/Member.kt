package entity.manyToMany.oneWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
open class Member {

    @Id
    @Column(name = "MEMBER_ID")
    var id: String? = null

    var username: String? = null


}