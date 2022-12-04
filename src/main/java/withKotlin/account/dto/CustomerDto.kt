package withKotlin.account.dto

import java.time.LocalDateTime

data class CustomerDto(

    val id: String,
    val name: String,
    val surname: String,
    val accounts: Set<CustomerAccountDto>
)
