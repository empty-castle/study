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

    val tx = em.transaction

    tx.begin()

    val member = Member().apply { name = "Member1" }
    em.persist(member)

    tx.commit()

    em.close()
    emf.close()
}