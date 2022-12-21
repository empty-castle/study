package entity.item

import entity.BaseEntity
import entity.Category
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
open class Item: BaseEntity() {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    open var id: Long? = null

    open var name: String? = null

    open var price: Int? = null

    open var stockQuantity: Int? = null

    @ManyToMany(mappedBy = "items")
    open var categories: MutableList<Category> = mutableListOf()
}