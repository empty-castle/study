package entity.compositeKey.embeddedId

import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
open class Parent {

    @EmbeddedId
    var id: ParentId? = null

    var name: String? = null
}