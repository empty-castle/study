package entity

import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class Address {

    var street: String? = null
    var city: String? = null
    var state: String? = null

    var zipCode: String? = null

//    AttributeOverride 와 같이 동작하지 못 한다.
//    @Embedded
//    var zipCode: Zipcode? = null
}
