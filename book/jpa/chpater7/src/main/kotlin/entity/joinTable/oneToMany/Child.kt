package entity.joinTable.oneToMany

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Child {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    var id: Long? = null

    var name: String? = null
}