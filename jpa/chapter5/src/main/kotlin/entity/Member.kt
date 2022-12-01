package entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Member {

    @Id
    @Column(name = "MEMBER_ID")
    var id: String? = null

    var userName: String? = null

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    var team: Team? = null
}