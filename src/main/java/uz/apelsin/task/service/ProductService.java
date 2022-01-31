package uz.apelsin.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.apelsin.task.model.Product;
import uz.apelsin.task.payload.ProductDto;
import uz.apelsin.task.projection.BulkProductsProjection;
import uz.apelsin.task.projection.HighDemandProductsProjection;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findAllDto(Pageable pageable);

    Page<Product> findAllEntity(Pageable pageable);

    Optional<ProductDto> getOneDto(Integer id);

    Optional<Product> getOneEntity(Integer id);

    Optional<Product> findById(Integer productId);

    Optional<Product> findProductByOrderId(Integer orderId);

    List<HighDemandProductsProjection> getHighDemandProducts();

    List<BulkProductsProjection> getBulkProducts();
}
