package entity

import javax.persistence.*

@Entity
@Table(name = "BOARD")
//@SequenceGenerator(
//    name = "BOARD_SEQ_GENERATOR",
//    sequenceName = "BOARD_SEQ",
//    initialValue = 1, allocationSize = 1
//)
@TableGenerator(
    name = "BOARD_SEQ_GENERATOR",
    table = "MY_SEQUENCES",
    pkColumnValue = "BOARD_SEQ", allocationSize = 1
)
class Board {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.IDENTITY) => AUTO_INCREMENT 가 있는 MySQL 진영에서 사용
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
    var id: Int? = null

    var data: String? = null
}