package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
