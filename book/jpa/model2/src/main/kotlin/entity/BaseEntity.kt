package entity

import java.util.Date
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity {

    open var createdDate: Date? = null
    open var lastModifiedDate: Date? = null
}