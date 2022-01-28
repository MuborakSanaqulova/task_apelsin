package uz.apelsin.task.service;

import uz.apelsin.task.model.Order;
import uz.apelsin.task.payload.OrderDetailProductNameDto;
import uz.apelsin.task.payload.OrderDto;
import uz.apelsin.task.payload.OrderRequestDto;
import uz.apelsin.task.payload.OrderResponseDto;

import java.util.Optional;

public interface OrderService {

    Optional<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto);

    Order save(Order order);

    Optional<OrderDetailProductNameDto> getOrderAndProductName(Integer order_id);
}
