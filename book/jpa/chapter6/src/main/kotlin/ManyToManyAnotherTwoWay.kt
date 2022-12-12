import entity.manyToMany.anotherTwoWay.Member
import entity.manyToMany.anotherTwoWay.Order
import entity.manyToMany.anotherTwoWay.Product
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

    val order = Order().apply {
        member = member1
        product = productA
        orderAmount = 2
    }
    em.persist(order)
}

private fun find(em: EntityManager) {

    val orderId = 1L
    val order = em.find(Order::class.java, orderId)

    val member = order.member
    val product = order.product

    println("member = ${member?.username}")
    println("product = ${product?.name}")
    println("orderAmount = ${order.orderAmount}")
}