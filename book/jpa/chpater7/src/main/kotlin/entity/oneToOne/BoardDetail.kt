package entity.oneToOne

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.MapsId
import javax.persistence.OneToOne

@Entity
open class BoardDetail {

    @Id
    var boardId: Long? = null

    @MapsId
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    var board: Board? = null

    var content: String? = null
}