package uz.apelsin.task.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Customer;
import uz.apelsin.task.projection.CustomerLastOrdersProjection;
import uz.apelsin.task.projection.NumberOfProductsInYearProjection;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.id, c.name, c.county, c.address, c.phone from customer c join orders o on c.id = o.customer_id where extract(year from o.date) != 2016.", nativeQuery = true)
    Page<Customer> findCustomersWithoutOrders(Pageable pageable);

    @Query(value = "select c.id as customerId, c.name as customerName, o.date as orderDate  from customer c inner join orders o on c.id = o.customer_id where o.id = (select o1.id from orders o1 where o1.customer_id = o.customer_id order by o1.date desc  limit 1)", nativeQuery = true)
    List<CustomerLastOrdersProjection> getCustomersLastOrders();

    @Query(value = "select c1.county as country, count(o1.id) as totalNumbersOfOrders from orders o1 join customer c1 on c1.id = o1.customer_id where extract(year from o1.date) = 2016 group by c1.county", nativeQuery = true)
    List<NumberOfProductsInYearProjection> getNumberOfProductsInYear();

}


