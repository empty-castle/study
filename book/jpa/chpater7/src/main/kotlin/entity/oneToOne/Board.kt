package entity.oneToOne

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
open class Board {

    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    var id: Long? = null

    var title: String? = null

    @OneToOne(mappedBy = "board")
    var boardDetail: BoardDetail? = null
}