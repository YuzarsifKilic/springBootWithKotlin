package withKotlin.account.dto;

import org.springframework.stereotype.Component;
import withKotlin.account.model.Transaction;

@Component
public class TransactionDtoConverter {

    public TranscationDto convert(Transaction from) {
        return new TranscationDto(
                from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate()
        );
    }
}
