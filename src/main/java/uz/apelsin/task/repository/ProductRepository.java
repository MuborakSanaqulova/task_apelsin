package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p.id, p.price, p.category_id, p.description, p.name, p.photo from product p join detail d on p.id = d.product_id join orders o on d.order_id = o.id where o.id =:orderId",nativeQuery = true)
    Optional<Product> findByOrderId(Integer orderId);

}
