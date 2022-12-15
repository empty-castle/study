package entity.mappedSuperclass

import javax.persistence.Entity

@Entity
open class Seller: BaseEntity() {

    var shopName: String? = null
}