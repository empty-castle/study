import entity.Order
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

    val order = em.find(Order::class.java, 4.toLong())
    val member = order.member

    println(member)

    val orderItem = order.orderItems[0]
    println(orderItem.item)

    tx.commit()
    em.close()
    emf.close()

}