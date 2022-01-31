package uz.apelsin.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.apelsin.task.model.Customer;
import uz.apelsin.task.payload.CustomerDto;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(Integer customerId);

    Page<CustomerDto> getCustomersWithoutOrders(Pageable pageable);
}
