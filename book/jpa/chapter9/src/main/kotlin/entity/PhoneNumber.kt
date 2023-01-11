package entity

import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class PhoneNumber {

    var areaCode: String? = null
    var localNumber: String? = null
    @ManyToOne
    var provider: PhoneServiceProvider? = null
}
