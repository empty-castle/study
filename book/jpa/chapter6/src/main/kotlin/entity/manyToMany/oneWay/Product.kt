package entity.manyToMany.oneWay

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
open class Product {

    @Id
    @Column(name = "MEMBER_ID")
    open var id: String? = null

    open var name: String? = null
}