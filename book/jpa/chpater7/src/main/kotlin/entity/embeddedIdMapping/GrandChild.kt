package entity.embeddedIdMapping

import javax.persistence.*

@Entity
open class GrandChild {

    @EmbeddedId
    var id: GrandChildId? = null

    @MapsId("childId")
    @ManyToOne
    @JoinColumns(
        JoinColumn(name = "PARENT_ID"),
        JoinColumn(name = "CHILD_ID")
    )
    var child: Child? = null

    var name: String? = null
}