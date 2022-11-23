import javax.persistence.Persistence

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val emf = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()
    val tx = em.transaction

    try {
        tx.begin()

        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()


}