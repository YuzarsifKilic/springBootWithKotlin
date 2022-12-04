package withKotlin.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import withKotlin.account.dto.AccountDto;
import withKotlin.account.dto.CreateAccountRequest;
import withKotlin.account.service.AccountService;

@RestController
@RequestMapping("/v1/account")
public class Accountcontroller {

    private final AccountService accountService;

    public Accountcontroller(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}
