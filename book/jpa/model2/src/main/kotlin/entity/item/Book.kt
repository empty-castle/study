package entity.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
open class Book: Item() {

    open var author: String? = null
    open var isbn: String? = null
}