package entity.oneToOne.mainTableKey.twoWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
open class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    var id: Long? = null

    var username: String? = null

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    var locker: Locker? = null
}