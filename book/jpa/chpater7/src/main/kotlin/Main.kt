import entity.compositeKey.idClass.Parent
import entity.compositeKey.idClass.ParentId
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()

    val parent = Parent().apply {
        id1 = "myId1"
        id2 = "myId2"
    }
    em.persist(parent)

    val parentId = ParentId("myId1", "myId2")
    em.find(Parent::class.java, parentId)

    val tx = em.transaction

    tx.commit()
    em.close()
    emf.close()
}