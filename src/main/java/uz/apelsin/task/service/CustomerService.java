package uz.apelsin.task.service;

import uz.apelsin.task.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(Integer customerId);
}
