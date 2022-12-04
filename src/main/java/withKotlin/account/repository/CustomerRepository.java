package withKotlin.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import withKotlin.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
