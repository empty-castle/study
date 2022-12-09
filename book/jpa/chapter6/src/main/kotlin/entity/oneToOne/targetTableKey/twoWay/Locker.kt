package entity.oneToOne.targetTableKey.twoWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
open class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    var id: Long? = null

    var name: String? = null

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    var member: Member? = null
}