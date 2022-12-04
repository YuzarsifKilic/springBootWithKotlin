package withKotlin.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import withKotlin.account.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
