package entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Team {

    @Id
    var id: Long? = null
    var name: String? = null
}