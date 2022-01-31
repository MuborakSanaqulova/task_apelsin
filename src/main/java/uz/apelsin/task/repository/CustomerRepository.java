package uz.apelsin.task.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.id, c.name, c.county, c.address, c.phone from customer c join orders o on c.id = o.customer_id where extract(year from o.date) != 2016.", nativeQuery = true)
    Page<Customer> findCustomersWithoutOrders(Pageable pageable);

}
