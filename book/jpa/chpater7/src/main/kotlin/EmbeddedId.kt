import entity.compositeKey.embeddedId.Parent
import entity.compositeKey.embeddedId.ParentId
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

fun main() {

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()

    val parent = Parent()
    val parentId = ParentId("myId1", "myId2")
    parent.apply {
        id = parentId
        name = "parentName"
    }
    em.persist(parent)

    val parentIdA = ParentId().apply {
        id1 = "myId1"
        id2 = "myId2"
    }

    println(parentId == parentIdA)
    println(parentId.hashCode())
    println(parentIdA.hashCode())
    println(parentId === parentIdA)

    em.close()
    emf.close()
}