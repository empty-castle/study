package entity.nonIdentification

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Parent {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    var id: Long? = null

    var name: String? = null
}