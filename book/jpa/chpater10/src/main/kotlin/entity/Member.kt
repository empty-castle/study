package entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Member {

    @Id
    var id: Long? = null

    @ManyToOne
    var team: Team? = null

    @Column(name = "name")
    var username: String? = null

    var age: Long? = null
}