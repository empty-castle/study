package entity.perClass

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
open class Movie: Item() {

    var director: String? = null
    var actor: String? = null
}