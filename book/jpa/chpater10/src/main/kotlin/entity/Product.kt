package entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Product {

    @Id
    var id: Long? = null

    var name: String? = null
    var price: Long? = null
    var stockAmount: Long? = null
}