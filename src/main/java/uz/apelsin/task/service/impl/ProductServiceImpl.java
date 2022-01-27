package uz.apelsin.task.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Product;
import uz.apelsin.task.payload.ProductDto;
import uz.apelsin.task.repository.ProductRepository;
import uz.apelsin.task.service.ProductService;
import uz.apelsin.task.service.mapper.ProductMapper;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Page<ProductDto> findAllDto(Pageable pageable) {
        return findAllEntity(pageable).map(productMapper::toDto);
    }

    @Override
    public Page<Product> findAllEntity(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<ProductDto> getOneDto(Integer id) {
        return getOneEntity(id).map(productMapper::toDto);
    }

    @Override
    public Optional<Product> getOneEntity(Integer id) {
        return productRepository.findById(id);
    }
}
