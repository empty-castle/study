package tutorial

import entity.Member

class Detached: Tutorial() {
    override fun test() {

        val member = createMember("memberA", "회원1")
        member.username = "회원명변경"

        mergeMember(member)

        em.close()
        emf.close()
    }

    private fun createMember(id: String, username: String): Member {

        val em1 = emf.createEntityManager()
        val tx1 = em1.transaction

        tx1.begin()

        val member = Member().apply {
            this.id = id
            this.username = username
        }
        em1.persist(member)

        tx1.commit()

        em1.close()

        return member
    }

    private fun mergeMember(member: Member) {

        val em2 = emf.createEntityManager()
        val tx2 = em2.transaction

        tx2.begin()
        val mergeMember = em2.merge(member)
        tx2.commit()

        println("member = ${member.username}")

        println("mergeMember = ${mergeMember.username}")

        println("em2 contains member = ${em2.contains(member)}")

        println("em2 contains mergeMeber = ${em2.contains(mergeMember)}")

        em2.close()
    }
}