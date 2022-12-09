package entity.manyToMany.extendTwoWay

import java.io.Serializable

data class MemberProductId(
    val member: String,
    val product: String,
): Serializable