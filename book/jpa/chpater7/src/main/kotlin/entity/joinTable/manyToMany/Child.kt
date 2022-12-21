package entity.joinTable.manyToMany

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
open class Child {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    var id: Long? = null

    var name: String? = null
}