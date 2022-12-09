package entity.oneToMany.twoWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
open class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    var id: Long? = null

    var name: String? = null

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    var members: MutableList<Member> = mutableListOf()
}