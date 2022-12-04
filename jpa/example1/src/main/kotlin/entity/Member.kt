package entity

import org.hibernate.annotations.DynamicUpdate
import java.util.Date
import javax.persistence.*

@Entity
//@DynamicUpdate => 수정된 값만 수정 쿼리에 포함, 컬럼 30개 이상인 경우에만 사용, 자매품 DynamicInsert
@Table(
    name = "MEMBER",
    uniqueConstraints = [UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = ["NAME", "AGE"]
    )]
)
class Member {

    @Id
    @Column(name = "ID")
    var id: String? = null

    @Column(name = "NAME", nullable = false, length = 10)
    var username: String? = null

    var age: Int? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    var roleType: RoleType? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    var createdDate: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date")
    var lastModifiedDate: Date? = null

    @Lob
    var description: String? = null
}