package entity

import java.util.*
import javax.persistence.Embeddable
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Embeddable
class Period {

    @Temporal(TemporalType.DATE)
    var startDate: Date? = null
    @Temporal(TemporalType.DATE)
    var endDate: Date? = null
}
