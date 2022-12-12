package entity.manyToMany.complexTwoWay

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@IdClass(MemberProductId::class)
open class MemberProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    open var member: Member? = null // MemberProductId.member 와 연결

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    open var product: Product? = null // MemberProductId.product 와 연결

    open var orderAmount: Int = 0
}