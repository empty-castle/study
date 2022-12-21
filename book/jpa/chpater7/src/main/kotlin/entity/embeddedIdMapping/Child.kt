package entity.embeddedIdMapping

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId

@Entity
open class Child {

    @EmbeddedId
    var id: ChildId? = null

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    var parent: Parent? = null
}