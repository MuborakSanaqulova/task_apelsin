package uz.apelsin.task.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Customer;
import uz.apelsin.task.payload.CustomerDto;
import uz.apelsin.task.repository.CustomerRepository;
import uz.apelsin.task.service.CustomerService;
import uz.apelsin.task.service.mapper.CustomerMapper;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return customerRepository.findById(customerId);
    }


    //task 4
    @Override
    public Page<CustomerDto> getCustomersWithoutOrders(Pageable pageable) {

        Page<Customer> customersWithoutOrders = customerRepository.findCustomersWithoutOrders(pageable);

        return customersWithoutOrders.map(customerMapper::toDto);
    }
}
