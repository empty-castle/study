package entity.embeddedIdMapping

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
open class Parent {

    @Id
    @Column(name = "PARENT_ID")
    var id: String? = null

    var name: String? = null
}