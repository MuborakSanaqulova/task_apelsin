package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Product;
import uz.apelsin.task.projection.BulkProductsProjection;
import uz.apelsin.task.projection.HighDemandProductsProjection;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p.id, p.price, p.category_id, p.description, p.name, p.photo from product p join detail d on p.id = d.product_id join orders o on d.orders_id = o.id where o.id =:orderId", nativeQuery = true)
    Optional<Product> findByOrderId(Integer orderId);

    @Query(value = "select p.id as productId, (select count(d.product_id) from detail d where d.product_id = p.id) as totalNumber from product p where (select count(d.product_id) from detail d where d.product_id = p.id) > 10", nativeQuery = true)
    List<HighDemandProductsProjection> findHighDemandProducts();

    @Query(value = "select p.id as productId, p.price as productPrice from product p join detail d on p.id = d.product_id where d.quantity>=8", nativeQuery = true)
    List<BulkProductsProjection> findBulkProducts();

}
