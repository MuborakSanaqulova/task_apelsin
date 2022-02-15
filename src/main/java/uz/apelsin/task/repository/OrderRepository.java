package uz.apelsin.task.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Orders;
import uz.apelsin.task.projection.OrdersWithoutInvoicesProjection;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "select * from orders left join detail d on orders.id = d.orders_id where orders.date<'2016-09-06' and d.orders_id is null", nativeQuery = true)
    Page<Orders> findOrderWithoutDetails(Pageable pageable);

    @Query(value = "select o.id as orderId, o.date as orderDate, (d.quantity * p.price) as totalPrice, p.price as unitPrice, d.quantity as quantity  from  orders o left join invoice i on o.id = i.orders_id join detail d on o.id = d.orders_id join product p on p.id = d.product_id where i.orders_id is null", nativeQuery = true)
    List<OrdersWithoutInvoicesProjection> getOrdersWithoutInvoices();

}
