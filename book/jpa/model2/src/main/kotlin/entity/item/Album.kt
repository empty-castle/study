package entity.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("A")
open class Album: Item() {

    open var artist: String? = null
    open var etc: String? = null
}