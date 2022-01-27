package uz.apelsin.task.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.apelsin.task.model.Order;
import uz.apelsin.task.payload.OrderDto;
import uz.apelsin.task.utility.EntityMapper;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface OrderMapper extends EntityMapper<OrderDto, Order> {

    @Mapping(target = "customerDto", source = "customer")
    OrderDto toDto(Order order);

    @Mapping(target = "customer", source = "customerDto")
    Order toEntity(OrderDto orderDto);

}
