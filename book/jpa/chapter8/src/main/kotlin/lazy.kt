import entity.proxy.lazy.Member
import entity.proxy.lazy.Team
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main() {

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()

    val member = em.find(Member::class.java, 1L)
    val team: Team? = member.team

    team?.name

//    print(team?.id)

    em.close()
    emf.close()
}