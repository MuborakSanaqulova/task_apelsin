package uz.apelsin.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.apelsin.task.model.Customer;
import uz.apelsin.task.payload.CustomerDto;
import uz.apelsin.task.projection.CustomerLastOrdersProjection;
import uz.apelsin.task.projection.NumberOfProductsInYearProjection;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(Integer customerId);

    Page<CustomerDto> getCustomersWithoutOrders(Pageable pageable);

    List<CustomerLastOrdersProjection> getCustomersLastOrders();

    List<NumberOfProductsInYearProjection> getNumberOfProductsInYear();
}
