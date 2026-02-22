package example.bankdata.database.account.models

import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
@Table(name = "account_user_info")

class UserInfoDb(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @field:NotNull
    var firstName: String,

    @field:NotNull
    var lastName: String
) {
    // for hibernate
    private constructor() : this(
        id = 0,
        firstName = "",
        lastName = ""
    )

    companion object {
        val empty = UserInfoDb(id = 0, firstName = "", lastName = "")
    }
}
