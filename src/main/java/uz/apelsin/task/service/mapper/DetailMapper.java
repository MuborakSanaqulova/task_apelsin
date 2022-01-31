package uz.apelsin.task.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.apelsin.task.model.Detail;
import uz.apelsin.task.payload.DetailDto;
import uz.apelsin.task.utility.EntityMapper;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, ProductMapper.class})
public interface DetailMapper extends EntityMapper<DetailDto, Detail> {

    @Mapping(target = "orderDto", source = "orders")
    @Mapping(target = "productDto", source = "product")
    DetailDto toDto(Detail detail);

    @Mapping(target = "orders", source = "orderDto")
    @Mapping(target = "product", source = "productDto")
    Detail toEntity(DetailDto detailDto);

}
