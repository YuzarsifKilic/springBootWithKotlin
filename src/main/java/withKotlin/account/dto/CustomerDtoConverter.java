package withKotlin.account.dto;

import org.springframework.stereotype.Component;
import withKotlin.account.model.Customer;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer from) {
        if (from == null) {
            return new AccountCustomerDto("", "", "");
        }
        return new AccountCustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname()
        );
    }
}
