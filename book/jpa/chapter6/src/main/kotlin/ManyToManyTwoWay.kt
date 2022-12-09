import entity.manyToMany.twoWay.Member
import entity.manyToMany.twoWay.Product
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

    val productA = Product().apply {
        id = "productA"
        name = "상품A"
    }
    em.persist(productA)

    val member = Member().apply {
        id = "member1"
        username = "회원1"
        addProduct(productA)
    }
    em.persist(member)
}

private fun find(em: EntityManager) {

    val member = em.find(Member::class.java, "member1")
    val products = member.products
    products.forEach {
        println("product.name = ${it.name}")
    }
}