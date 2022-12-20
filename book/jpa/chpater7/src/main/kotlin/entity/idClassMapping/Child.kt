package entity.idClassMapping

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@IdClass(ChildId::class)
open class Child {

    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    var parent: Parent? = null

    @Id
    @Column(name = "CHILD_ID")
    var childId: String? = null

    var name: String? = null
}