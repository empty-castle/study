package cascade

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Child(
    @Id @GeneratedValue
    val id: Long,
    @ManyToOne
    var parent: Parent?
)