package withKotlin.account.dto

import withKotlin.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TranscationDto(

    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?
)
