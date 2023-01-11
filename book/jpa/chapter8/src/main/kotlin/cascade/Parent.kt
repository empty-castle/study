package cascade

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Parent(
    @Id @GeneratedValue
    val id: Long,
    @OneToMany(mappedBy = "parent")
    var children: MutableList<Child>
)