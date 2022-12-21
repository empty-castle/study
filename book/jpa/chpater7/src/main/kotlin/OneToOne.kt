import entity.oneToOne.Board
import entity.oneToOne.BoardDetail
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main() {

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()

    var board = Board().apply {
        title = "제목"
    }
    em.persist(board)

    val boardDetail = BoardDetail().apply {
        content = "내용"
        board = board
    }
    em.persist(boardDetail)

    em.close()
    emf.close()
}