package uz.apelsin.task.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.apelsin.task.model.Orders;
import uz.apelsin.task.payload.OrderDto;
import uz.apelsin.task.utility.EntityMapper;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface OrderMapper extends EntityMapper<OrderDto, Orders> {

    @Mapping(target = "customerDto", source = "customer")
    OrderDto toDto(Orders orders);

    @Mapping(target = "customer", source = "customerDto")
    Orders toEntity(OrderDto orderDto);

}
