package uz.apelsin.task.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Category;
import uz.apelsin.task.payload.CategoryDto;
import uz.apelsin.task.repository.CategoryRepository;
import uz.apelsin.task.service.CategoryService;
import uz.apelsin.task.service.mapper.CategoryMapper;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public Page<CategoryDto> findAllDto(Pageable pageable) {
        return findAllEntity(pageable).map(categoryMapper::toDto);
    }

    @Override
    public Page<Category> findAllEntity(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<CategoryDto> getOneDto(Integer id) {
        return getOneEntity(id).map(categoryMapper::toDto);
    }

    @Override
    public Optional<Category> getOneEntity(Integer id) {
        return categoryRepository.findById(id);
    }
}
