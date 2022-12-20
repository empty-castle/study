package entity.idClassMapping

import javax.persistence.*

@Entity
@IdClass(GrandChildId::class)
open class GrandChild {

    @Id
    @ManyToOne
    @JoinColumns(
        JoinColumn(name = "PARENT_ID"),
        JoinColumn(name = "CHILD_ID")
    )
    var child: Child? = null

    @Id
    @Column(name = "GRANDCHILD_ID")
    var id: String? = null

    var name: String? = null
}