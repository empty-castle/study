package entity.nonIdentification

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
open class Child {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    var id: Long? = null

    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    var parent: Parent? = null
}