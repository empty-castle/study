package tutorial

import entity.Member
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

class PersistenceContext: Tutorial {
    override fun test() {

        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
        val em: EntityManager = emf.createEntityManager()
        val tx: EntityTransaction = em.transaction

        try {
            tx.begin()

            val member = Member().apply {
                id = "member1"
                username = "회원1"
            }

//        영속성 컨테스트에 등록
            em.persist(member)

//        1차 캐시에 있는 엔티티를 가져온다
            val findMember1a = em.find(Member::class.java, "member1")
//        마찬가지로 1차 캐시에 있는 엔티티를 가져온다
            val findMember1b = em.find(Member::class.java, "member1")
//        1a 와 1b 모두 1차 캐시에 있는 객체를 가져왔으니 동일성 true
            println(findMember1a == findMember1b)

//        member2는 영속성 컨텍스트에 존재하지 않으니 조회 쿼리 => 그 이후 영속성 컨테스트에 캐싱
            val findMember2 = em.find(Member::class.java, "member2")

//        스냅샷과 엔티티를 비교 수정 쿼리가 쓰기 지연 SQL 저장소에 추가된다. => 변경감지
            member.age = 30

            tx.commit()
        } catch (e: Exception) {
            tx.rollback()
        } finally {
            em.close()
        }
        emf.close()
    }
}