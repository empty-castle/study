package entity.proxy.lazy

import javax.persistence.*

@Entity
open class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    var id: Long? = null

    var username: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    var team: Team? = null
}