import entity.proxy.Member
import entity.proxy.Team
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()

//    val team = em.getReference(Team::class.java, "team1")
//    print(team.id) // 이미 proxy 객체가 id 는 가지고 있으니까 초기화 안 됨

    val member = em.find(Member::class.java, "member1")
    val team = em.getReference(Team::class.java, "team1")
    member.team = team // 연관관계를 설정할 때는 식별자 값만 사용하므로 team 객체 DB에 접근 하지 않는다

    val loaded = emf.persistenceUnitUtil.isLoaded(team)
    println(loaded) // 초기화가 되면 true 아니면 false

    println(member.javaClass.name) // ~~javassist 가 붙어있으면 proxy 객체다

    em.close()
    emf.close()
}