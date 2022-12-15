package entity.compositeKey.idClass

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity
@IdClass(ParentId::class)
open class Parent {

    @Id
    @Column(name = "PARENT_ID1")
    var id1: String? = null

    @Id
    @Column(name = "PARENT_ID2")
    var id2: String? = null

    var name: String? = null
}