package entity.joinTable.manyToOne

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Parent {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    var id: Long? = null

    var name: String? = null

    @OneToMany(mappedBy = "parent")
    var child: MutableList<Child> = mutableListOf()
}