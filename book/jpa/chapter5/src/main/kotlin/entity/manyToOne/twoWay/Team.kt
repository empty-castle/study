package entity.manyToOne.twoWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table
class Team {

    @Id
    @Column(name = "TEAM_ID")
    var id: String? = null

    var name: String? = null

    @OneToMany(mappedBy = "team")
    var members: MutableList<Member> = mutableListOf()

    fun addMember(member: Member) {
        this.members.add(member)
        if (member.team != this) {
            member.team = this
        }
    }
}