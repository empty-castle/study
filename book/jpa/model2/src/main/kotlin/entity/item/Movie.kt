package entity.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
open class Movie: Item() {

    open var director: String? = null
    open var actor: String? = null
}