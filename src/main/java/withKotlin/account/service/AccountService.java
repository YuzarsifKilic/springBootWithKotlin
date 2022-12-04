package withKotlin.account.service;

import org.springframework.stereotype.Service;
import withKotlin.account.dto.AccountDto;
import withKotlin.account.dto.AccountDtoConverter;
import withKotlin.account.dto.CreateAccountRequest;
import withKotlin.account.model.Account;
import withKotlin.account.model.Customer;
import withKotlin.account.model.Transaction;
import withKotlin.account.repository.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          TransactionService transactionService,
                          AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = transactionService.initiatemoney(
                    account, createAccountRequest.getInitialCredit());
            account.getTransaction().add(transaction);
        }

        return accountDtoConverter.convert(accountRepository.save(account));
    }
}
