import entity.manyToMany.complexTwoWay.MemberProduct
import entity.manyToMany.complexTwoWay.Member
import entity.manyToMany.complexTwoWay.MemberProductId
import entity.manyToMany.complexTwoWay.Product
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main() {
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()
    val tx = em.transaction

    tx.begin()

    save(em)
    find(em)

    tx.commit()
    em.close()
    emf.close()
}

private fun save(em: EntityManager) {

    val member1 = Member().apply {
        id = "member1"
        username = "회원1"
    }
    em.persist(member1)

    val productA = Product().apply {
        id = "productA"
        name = "상품A"
    }
    em.persist(productA)

    val memberProduct = MemberProduct().apply {
        member = member1
        product = productA
        orderAmount = 2
    }
    em.persist(memberProduct)
}

private fun find(em: EntityManager) {

    val memberProductId = MemberProductId("member1", "productA")

    val memberProduct = em.find(MemberProduct::class.java, memberProductId)

    val member = memberProduct.member
    val product = memberProduct.product

    println("member = ${member?.username}")
    println("product = ${product?.name}")
    println("orderAmount = ${memberProduct.orderAmount}")
}