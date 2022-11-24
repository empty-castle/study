package tutorial

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

abstract class Tutorial {

    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("jpabook")
    val em: EntityManager = emf.createEntityManager()
    val tx: EntityTransaction = em.transaction

    abstract fun test()
}