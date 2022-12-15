package entity.compositeKey.embeddedId

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open data class ParentId(
    @Column(name = "PARENT_ID1")
    open var id1: String?,
    @Column(name = "PARENT_ID2")
    open var id2: String?,
): Serializable {
    constructor() : this(null, null)
}