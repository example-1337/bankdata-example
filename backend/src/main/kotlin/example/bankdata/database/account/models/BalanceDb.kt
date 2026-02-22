package example.bankdata.database.account.models

import jakarta.persistence.*
import java.math.*

@Entity
@Table(name = "balances")
class BalanceDb(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var balance: BigDecimal
) {

    // for hibernate
    private constructor() : this(
        id = 0,
        balance = BigDecimal.ZERO
    )

    companion object {
        val empty = BalanceDb(id = 0, balance = BigDecimal.ZERO)
    }
}