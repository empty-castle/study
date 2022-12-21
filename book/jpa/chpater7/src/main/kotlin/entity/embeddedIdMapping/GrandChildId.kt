package entity.embeddedIdMapping

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class GrandChildId(
    var childId: ChildId?,
    @Column(name = "GRANDCHILD_ID")
    var id: String?
): Serializable {
    constructor() : this(null, null)
}
