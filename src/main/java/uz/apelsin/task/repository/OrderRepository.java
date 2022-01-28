package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Order;
import uz.apelsin.task.model.Product;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
