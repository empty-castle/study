package entity.idClassMapping

import java.io.Serializable

data class GrandChildId(
    var child: ChildId?,
    var id: String?
): Serializable