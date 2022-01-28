package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
