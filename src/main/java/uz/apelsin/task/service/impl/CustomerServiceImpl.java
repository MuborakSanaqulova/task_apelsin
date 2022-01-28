package uz.apelsin.task.service.impl;

import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Customer;
import uz.apelsin.task.repository.CustomerRepository;
import uz.apelsin.task.service.CustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return customerRepository.findById(customerId);
    }
}
