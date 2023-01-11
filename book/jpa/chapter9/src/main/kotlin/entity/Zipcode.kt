package entity

import javax.persistence.Embeddable

@Embeddable
class Zipcode {

    var zip: String? = null
    var plusFour: String? = null
}
