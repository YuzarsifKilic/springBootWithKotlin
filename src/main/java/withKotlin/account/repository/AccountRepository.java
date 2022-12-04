package withKotlin.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import withKotlin.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}
