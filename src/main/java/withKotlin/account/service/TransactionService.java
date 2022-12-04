package withKotlin.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import withKotlin.account.model.Account;
import withKotlin.account.model.Transaction;
import withKotlin.account.repository.TransactionRepository;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiatemoney(final Account account, BigDecimal amount) {

        return transactionRepository.save(
                new Transaction(amount, account)
        );
    }
}
