package entity.embeddedIdMapping

import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.MapsId

@Embeddable
data class ChildId(
    @MapsId("parentId")
    var parentId: String?,
    var id: String?
): Serializable {
    constructor() : this(null, null)
}