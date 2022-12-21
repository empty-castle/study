package entity.nonIdentification

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
open class GrandChild {

    @Id
    @GeneratedValue
    @Column(name = "GRANDCHILD_ID")
    var id: Long? = null

    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "CHILD_ID")
    var child: Child? = null
}