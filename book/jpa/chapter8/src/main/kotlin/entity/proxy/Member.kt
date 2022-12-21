package entity.proxy

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
open class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    var id: Long? = null

    var username: String? = null

    @ManyToOne
    var team: Team? = null
}