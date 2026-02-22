package example.bankdata.database.account.models

import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
@Table(name = "accounts")
class AccountDb(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @field:NotNull
    @Column(name = "accountNumber", unique = true)
    var accountNumber: String,

    @OneToOne(cascade = [CascadeType.ALL])
    var balance: BalanceDb,

    @OneToOne(cascade = [CascadeType.ALL])
    var userInfo: UserInfoDb
) {
    // for hibernate
    private constructor() : this(
        id = 0,
        accountNumber = "",
        balance = BalanceDb.empty,
        userInfo = UserInfoDb.empty
    )
}