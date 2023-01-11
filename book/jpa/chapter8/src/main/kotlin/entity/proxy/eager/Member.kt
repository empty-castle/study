package entity.proxy.eager

import javax.persistence.*

@Entity
open class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    var id: Long? = null

    var username: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    var team: Team? = null
}