package entity.joinTable.manyToMany

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
open class Parent {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    var id: Long? = null

    var name: String? = null

    @ManyToMany
    @JoinTable(
        name = "PARENT_CHILD",
        joinColumns = [JoinColumn(name = "PARENT_ID")],
        inverseJoinColumns = [JoinColumn(name = "CHILD_ID")]
    )
    var child: MutableList<Child> = mutableListOf()
}