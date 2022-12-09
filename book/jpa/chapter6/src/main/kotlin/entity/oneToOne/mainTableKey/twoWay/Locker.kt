package entity.oneToOne.mainTableKey.twoWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
open class Locker {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    var id: Long? = null

    var name: String? = null

    @OneToOne(mappedBy = "locker")
    var member: Member? = null
}