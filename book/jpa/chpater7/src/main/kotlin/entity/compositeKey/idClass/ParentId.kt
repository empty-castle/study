package entity.compositeKey.idClass

import java.io.Serializable

data class ParentId(
    val id1: String,
    val id2: String,
): Serializable