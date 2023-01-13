import dto.UserDTO
import entity.Member
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()

    //    val jpql = "select m from Member m where m.username = 'kim'"
    //    val resultList = em.createQuery(jpql, Member::class.java).resultList

    //    결과가 하나인 경우에만, 아니면 에러 뜸
    //    val resultList = em.createQuery(jpql, Member::class.java).singleResult

    //    val criteriaBuilder = em.criteriaBuilder
    //    val createQuery = criteriaBuilder.createQuery(Member::class.java)
    //    val m = createQuery.from(Member::class.java)
    //    val memberCriteriaQuery = createQuery
    //        .select(m)
    //        .where(criteriaBuilder.equal(m.get("username"), "kim"))
    //    val resultList = em.createQuery(memberCriteriaQuery).resultList

    //    val sql = "SELECT ID, NAME FROM MEMBER WHERE NAME = 'kim'"
    //    val resultList = em.createNamedQuery(sql).resultList

    /* parameter */ //    val usernameParam = "User1"
    //    val query = em.createQuery("select m from Member m where m.username = :username", Member::class.java)
    //    val resultList = query.setParameter("username", usernameParam).resultList

    /* dto */ //    val resultList = em.createQuery("select new dto.UserDTO(m.username, m.age) from Member m", UserDTO::class.java)
    //        .resultList

    /* paging */ //    val resultList = em.createQuery("select m from Member m order by m.username DESC", Member::class.java)
    //        .setFirstResult(10)
    //        .setMaxResults(20)
    //        .resultList

    /* func */ //    val resultList =
    //        em.createQuery("select count(m), sum(m.age), avg(m.age), max(m.age), min(m.age) from Member m").resultList

    /* group */
    val resultList =
        em.createQuery("select count(m), sum(m.age), avg(m.age), max(m.age), min(m.age) from Member m left join m.team t group by t.name having avg(m.age) > 10").resultList


    resultList.forEach { println(it.username) }

    em.close()
    emf.close()

}