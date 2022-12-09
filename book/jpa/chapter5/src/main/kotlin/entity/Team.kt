package entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
open class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    var id: Long? = null

    var name: String? = null
}