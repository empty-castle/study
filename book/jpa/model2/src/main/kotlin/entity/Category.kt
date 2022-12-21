package entity

import entity.item.Item
import javax.persistence.*

@Entity
class Category: BaseEntity() {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    var id: Long? = null

    var name: String? = null

    @ManyToMany
    @JoinTable(
        name = "CATEGORY_ITEM",
        joinColumns = [JoinColumn(name = "CATEGORY_ID")],
        inverseJoinColumns = [JoinColumn(name = "ITEM_ID")]
    )
    var items: MutableList<Item> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    var parent: Category? = null

    @OneToMany(mappedBy = "parent")
    var child: MutableList<Category> = mutableListOf()

    fun addChildCategory(child: Category) {
        this.child.add(child)
        child.parent = this
    }

    fun addItem(item: Item) {
        items.add(item)
    }
}