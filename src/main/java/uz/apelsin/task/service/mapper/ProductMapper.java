package uz.apelsin.task.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.apelsin.task.model.Product;
import uz.apelsin.task.payload.ProductDto;
import uz.apelsin.task.utility.EntityMapper;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper extends EntityMapper<ProductDto, Product> {

    @Mapping(target = "categoryDto", source = "category")
    ProductDto toDto(Product product);

    @Mapping(target = "category", source = "categoryDto")
    Product toEntity(ProductDto productDto);

}
