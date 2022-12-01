package entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    var id: Long? = null

    var name: String? = null

    var price: Int? = null

    var stockQuantity: Int? = null
}