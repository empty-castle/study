package entity.compositeKey.embeddedId

import java.io.Serializable
import java.util.Objects
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class ParentId: Serializable {

    @Column(name = "PARENT_ID1")
    open var id1: String? = null

    @Column(name = "PARENT_ID2")
    open var id2: String? = null

    constructor()
    constructor(id1: String?, id2: String?) {
        this.id1 = id1
        this.id2 = id2
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
        if (other === this) {
            return true
        }
        if (other !is ParentId) {
            return false
        }
        return this.id1 == other.id1 && this.id2 == other.id2
    }

    override fun hashCode(): Int {
        return Objects.hash(id1, id2)
    }
}