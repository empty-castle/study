package entity.manyToMany.complexTwoWay

import java.io.Serializable

data class MemberProductId(
    val member: String? = null,
    val product: String? = null,
): Serializable