package entity.manyToOne.oneWay

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
}