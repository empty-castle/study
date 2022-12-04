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


//    val em: EntityManager = emf.createEntityManager()
//    logic1(em)
//    em.close()

//    val em1 = emf.createEntityManager()
//    logic2(em1)
//    em1.close()

    val em2 = emf.createEntityManager()
    login3(em2)
    em2.close()

    emf.close()
}

private fun logic1(em: EntityManager) {

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
    tx.commit()
}

private fun queryLogicJoin(em: EntityManager) {

    val jpql = "select m from Member m join m.team t where t.name=:teamName"

    val resultList: List<Member> = em.createQuery(jpql, Member::class.java)
        .setParameter("teamName", "팀1")
        .resultList

    resultList.forEach { println("[query] member.username = ${it.userName}") }
}

private fun logic2(em: EntityManager) {
    val tx = em.transaction
    tx.begin()

    /*
    *
    * em 에 영속 엔티티로 등록된 team1 에 대한 객체가 업데이트가 되질 않아서 em1 을 새로 생성
    *
    * em.find 를 해도 캐싱된 객체를 가지고 오기 때문에 members 의 사이즈가 늘어나질 않는다.
    *
    * */

    // 일대다 컬렉션 조회
    val findTeam1 = em.find(Team::class.java, "team1")
    val members = findTeam1.members
    members.forEach {
        println("[OneToMany]member.username = ${it.userName}")
    }

    tx.commit()
}

private fun login3(em: EntityManager) {
    val tx = em.transaction
    tx.begin()

    val team1 = Team().apply {
        id = "team1"
        name = "팀1"
    }
    em.persist(team1)

    val team2 = Team().apply {
        id = "team2"
        name = "팀2"
    }
    em.persist(team2)

    val member1 = Member().apply {
        id = "member1"
        userName = "회원1"
        team = team1
    }
    team1.members.add(member1)
    em.persist(member1)

    val member2 = Member().apply {
        id = "member2"
        userName = "회원2"
        team = team1
    }
    team1.members.add(member2)
    em.persist(member2)

    /*
    *
    * // Team.member 가 연관관계의 주인이 아니기 때문에 아래 코드는 무시된다.
    * team1.members.add(member1)
    * team1.members.add(member2)
    *
    * 하지만 객체 자체를 다뤄서 무언가를 해야 할때에는 양쪽 객체에 값을 입력하는 것이 좋다.
    *
    * */

    // 만약 위의 조언대로 객체 자체를 다루기 위해 양쪽 객체에 값을 입력한 경우
    member1.team = team2

    // 위 처럼 작성하여도 team1.members 에는 기존 관계가 아직 남아있다.
    val members = team1.members
    members.forEach { println("[Remain relation]${it.userName}") }

    // 때문에 남아있는 관계를 지우는 단계가 추가로 필요하다.
    members.remove(member1)
    members.forEach { println("[Delete remain relation]${it.userName}") }

    tx.commit()
}