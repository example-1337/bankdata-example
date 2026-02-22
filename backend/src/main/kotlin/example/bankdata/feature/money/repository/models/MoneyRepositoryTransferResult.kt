package example.bankdata.feature.money.repository.models

import kotlinx.serialization.Serializable

@Serializable
sealed interface MoneyRepositoryTransferResult {
    @Serializable
    object Success : MoneyRepositoryTransferResult

    @Serializable
    object InsufficientBalance : MoneyRepositoryTransferResult

    @Serializable
    object RecipientNotFound : MoneyRepositoryTransferResult

    @Serializable
    object SenderNotFound : MoneyRepositoryTransferResult

    @Serializable
    object PossibleFraud : MoneyRepositoryTransferResult

    @Serializable
    object SameAccountError : MoneyRepositoryTransferResult
}