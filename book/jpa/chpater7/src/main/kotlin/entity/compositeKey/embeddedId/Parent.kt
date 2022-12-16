package entity.compositeKey.embeddedId

import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
open class Parent {

    @EmbeddedId
    open var id: ParentId? = null

    open var name: String? = null
}