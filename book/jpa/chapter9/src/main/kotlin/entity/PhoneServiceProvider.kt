package entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class PhoneServiceProvider {

    @Id
    var name: String? = null
}
