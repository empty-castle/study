package tutorial

import entity.Board
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

class GeneratedValue: Tutorial {

    override fun test() {

        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
        val em: EntityManager = emf.createEntityManager()
        val tx: EntityTransaction = em.transaction

        val board = Board()
        em.persist(board)
        println("board.id = ${board.id}")

        /*
        * Entity 가 영속 상태가 되려면 식별자가 꼭 필요
        * but, IDENTITY 식별자 생성 전략은 데이터베이스에 저장이 되어야 식별자를 구할 수 있으니
        * em.persist 를 호출하는 즉시 INSERT => 쓰기 지연이 동작하지 않음
        * */

        /*
        * SEQUENCE 의 경우에는 persist 가 호출될때 식별자를 구해오기 떄문에 Entity 가 영속 상태가 된다.
        * flush 가 일어나지 않으면 tx.commit() INSERT 가 호출되지 않는다. => 쓰기 지연
        * */

        /*
        * AUTO 로 설정하고 스키마 자동 생성 기능을 사용하면
        * DB 에 따라서 JPA 가 알아서 다 생성해버리니 개발 초기에 도움이 된다.
        * */

        /*
        * 기본 키는 변하면 안 된다는 기본 원칙
        * => setId 를 외부에 공개하지 않는 것도 문제를 예방하는 방법이 될 수 있다.
        * */

        em.close()
        emf.close()
    }
}