import entity.Member
import entity.Team
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

    // 생성
    tx.begin()
    val team1 = Team().apply {
        id = "team1"
        name = "팀1"
    }
    em.persist(team1)

    val member1 = Member().apply {
        id = "member1"
        userName = "회원1"
        team = team1
    }
    em.persist(member1)

    val member2 = Member().apply {
        id = "member2"
        userName = "회원2"
        team = team1
    }
    em.persist(member2)

    // 객체 그래프 탐색
    val member = em.find(Member::class.java, "member1")
    val team = member.team
    println("팀 이름 = ${team?.name}")
    // JPQL 조회
    queryLogicJoin(em)

    // 수정
    val team2 = Team().apply {
        id = "team2"
        name = "팀2"
    }
    em.persist(team2)
//    member.team = team2

    // 연관관계 제거
//    member.team = null

    // 연관 엔티티 삭제
//    member1.team = null
//    member2.team = null
//    em.remove(team)

    // TODO 일대다 컬렉션 조회
    val findTeam1 = em.find(Team::class.java, "team1")
    val members = findTeam1.members
    members.forEach {
        println("*** member.username = ${it.userName}")
    }
    tx.commit()

    em.close()
    emf.close()
}

private fun queryLogicJoin(em: EntityManager) {

    val jpql = "select m from Member m join m.team t where t.name=:teamName"

    val resultList: List<Member> = em.createQuery(jpql, Member::class.java)
        .setParameter("teamName", "팀1")
        .resultList

    resultList.forEach { println("[query] member.username = ${it.userName}") }
}