package entity

import javax.persistence.*

@Entity
class Member {

    var name: String? = null
    var age: Int? = null

    @Embedded
    var workPeriod: Period? = null

    @Embedded
    var homeAddress: Address? = null

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = [JoinColumn(name = "MEMBER_ID")])
    @Column(name = "FOOD_NAME")
    var favoriteFoods: MutableSet<String> = mutableSetOf()

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = [JoinColumn(name = "MEMBER_ID")])
    var addressHistory: MutableList<Address> = mutableListOf()

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "street", column = Column(name = "COMPANY_STREET")),
        AttributeOverride(name = "city", column = Column(name = "COMPANY_CITY")),
        AttributeOverride(name = "state", column = Column(name = "COMPANY_STATE")),
        AttributeOverride(name = "zipCode", column = Column(name = "COMPANY_ZIPCODE")), // => Embedded zipcode 와 조합하면 에러 발생한다.
    )
    var companyAddress: Address? = null

    @Embedded
    var phoneNumber: PhoneNumber? = null

    @Id
    @GeneratedValue
    var id: Long? = null
}