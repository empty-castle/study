package entity.compositeKey.idClass

import javax.persistence.*

@Entity
open class Child {

    @Id
    var id: String? = null

    @ManyToOne
    @JoinColumns(
        JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),
        JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
    )
    var parent: Parent? = null
}