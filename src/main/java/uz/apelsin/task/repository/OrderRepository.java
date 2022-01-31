package uz.apelsin.task.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "select * from orders left join detail d on orders.id = d.order_id where orders.date<'2016-09-06' and d.order_id is null", nativeQuery = true)
    Page<Orders> findOrderWithoutDetails(Pageable pageable);
}
