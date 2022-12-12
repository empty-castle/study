package entity.manyToMany.complexTwoWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
open class Product {

    @Id
    @Column(name = "MEMBER_ID")
    open var id: String? = null

    open var name: String? = null
}