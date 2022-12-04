package withKotlin.account.service;

import org.springframework.stereotype.Service;
import withKotlin.account.exception.CustomerNotFoundException;
import withKotlin.account.model.Customer;
import withKotlin.account.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id:" + id));
    }
}
