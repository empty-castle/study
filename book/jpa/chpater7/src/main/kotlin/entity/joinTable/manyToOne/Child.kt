package entity.joinTable.manyToOne

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToOne

@Entity
class Child {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    var id: Long? = null

    var name: String? = null

    @ManyToOne(optional = false)
    @JoinTable(
        name = "PARENT_CHILD",
        joinColumns = [JoinColumn(name = "CHILD_ID")],
        inverseJoinColumns = [JoinColumn(name = "PARENT_ID")]
    )
    var parent: Parent? = null
}