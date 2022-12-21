package entity.joinTable.oneToMany

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany

@Entity
class Parent {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    var id: Long? = null

    var name: String? = null

    @OneToMany
    @JoinTable(
        name = "PARENT_CHILD",
        joinColumns = [JoinColumn(name = "PARENT_ID")],
        inverseJoinColumns = [JoinColumn(name = "CHILD_ID")]
    )
    var child: MutableList<Child> = mutableListOf()
}