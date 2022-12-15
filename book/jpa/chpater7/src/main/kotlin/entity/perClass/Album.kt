package entity.perClass

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("A")
open class Album: Item() {

    var artist: String? = null
}