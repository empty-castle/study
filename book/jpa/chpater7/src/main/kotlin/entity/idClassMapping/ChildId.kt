package entity.idClassMapping

import java.io.Serializable

data class ChildId(
    var parent: String?,
    var childId: String?
): Serializable