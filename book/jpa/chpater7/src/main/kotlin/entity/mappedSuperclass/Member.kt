package entity.mappedSuperclass

import javax.persistence.Entity

@Entity
open class Member: BaseEntity() {

    var email: String? = null
}