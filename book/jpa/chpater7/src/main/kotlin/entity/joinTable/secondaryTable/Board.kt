package entity.joinTable.secondaryTable

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.SecondaryTable
import javax.persistence.Table

@Entity
@Table(name = "BOARD")
@SecondaryTable(
    name = "BOARD_DETAIL",
    pkJoinColumns = [PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID")]
)
class Board {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    var id: Long? = null

    var title: String? = null

    @Column(table = "BOARD_DETAIL")
    var content: String? = null
}