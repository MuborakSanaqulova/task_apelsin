package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category join product p on category.id = p.category_id where p.id=:productId", nativeQuery = true)
    Optional<Category> findCategoryByProductId(Integer productId);
}
