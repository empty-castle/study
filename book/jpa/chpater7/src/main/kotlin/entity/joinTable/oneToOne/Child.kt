package entity.joinTable.oneToOne

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Child {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    var id: Long? = null

    var name: String? = null

    @OneToOne(mappedBy = "child")
    var parent: Parent? = null
}