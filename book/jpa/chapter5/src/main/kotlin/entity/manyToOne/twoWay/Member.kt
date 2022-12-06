package entity.manyToOne.twoWay

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
        set(value) {
            field = value
            if (value != null && !value.members.contains(this)) {
                value.members.add(this)
            }
        }
}