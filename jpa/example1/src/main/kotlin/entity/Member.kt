package entity

import RoleType.RoleType
import org.hibernate.annotations.DynamicUpdate
import java.util.Date
import javax.persistence.*

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

    @Enumerated(EnumType.STRING)
    var roleType: RoleType? = null

    @Temporal(TemporalType.TIMESTAMP)
    var createdDate: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    var lastModifiedDate: Date? = null

    @Lob
    var description: String? = null
}