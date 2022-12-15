package entity.join

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    var id: Long? = null

    var name: String? = null
    var price: Int = 0
}