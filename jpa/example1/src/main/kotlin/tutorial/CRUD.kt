package tutorial

import entity.Member
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

class CRUD: Tutorial {
    override fun test() {

        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
        val em: EntityManager = emf.createEntityManager()
        val tx: EntityTransaction = em.transaction

        try {
            tx.begin()

            val id = "id3"
            val member = Member().apply {
                this.id = id
                username = "지한"
                age = 2
            }

            em.persist(member)

            member.age = 20

            val findMember = em.find(Member::class.java, id)
            println("findMember=${findMember.username}, age=${findMember.age}")

            val members = em.createQuery("select m from Member m", Member::class.java)
                .resultList
            println("members.size=${members.size}")

            em.remove(member)

            tx.commit()
        } catch (e: Exception) {
            tx.rollback()
        } finally {
            em.close()
        }
        emf.close()
    }
}