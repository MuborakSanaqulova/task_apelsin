package uz.apelsin.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.apelsin.task.model.Category;
import uz.apelsin.task.payload.CategoryDto;

import java.util.Optional;

public interface CategoryService {
    Page<CategoryDto> findAllDto(Pageable pageable);

    Page<Category> findAllEntity(Pageable pageable);

    Optional<CategoryDto> getCategoryByProductIdDto(Integer productId);

    Optional<Category> getCategoryByProductIdEntity(Integer productId);
}
