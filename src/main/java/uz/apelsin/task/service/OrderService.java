package uz.apelsin.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.apelsin.task.model.Orders;
import uz.apelsin.task.payload.OrderDetailProductNameDto;
import uz.apelsin.task.payload.OrderDto;
import uz.apelsin.task.payload.OrderRequestDto;
import uz.apelsin.task.payload.OrderResponseDto;

import java.util.Optional;

public interface OrderService {

    Optional<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto);

    Orders save(Orders orders);

    Optional<OrderDetailProductNameDto> getOrderAndProductName(Integer order_id);

    Page<OrderDto> getOrdersWithoutDetails(Pageable pageable);
}
