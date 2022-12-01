import entity.Item
import entity.Member
import entity.Order
import entity.OrderItem
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em: EntityManager = emf.createEntityManager()
    val tx: EntityTransaction = em.transaction

    tx.begin()

    em.persist(Member())
    em.persist(Order())
    em.persist(OrderItem())
    em.persist(Item())

    tx.commit()
    em.close()
    emf.close()

}