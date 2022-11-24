package entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
//@DynamicUpdate => 수정된 값만 수정 쿼리에 포함, 컬럼 30개 이상인 경우에만 사용, 자매품 DynamicInsert
@Table(name = "MEMBER")
class Member {

    @Id
    @Column(name = "ID")
    var id: String? = null

    @Column(name = "NAME")
    var username: String? = null

    var age: Int? = null
}