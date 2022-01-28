package uz.apelsin.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.apelsin.task.common.ErrorMessage;
import uz.apelsin.task.common.Response;
import uz.apelsin.task.model.enums.Status;
import uz.apelsin.task.payload.OrderDetailProductNameDto;
import uz.apelsin.task.payload.OrderDto;
import uz.apelsin.task.payload.OrderRequestDto;
import uz.apelsin.task.payload.OrderResponseDto;
import uz.apelsin.task.service.OrderService;

import java.util.Optional;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        Optional<OrderResponseDto> result = orderService.createOrder(orderRequestDto);

        if (result.isEmpty())
            return ResponseEntity.badRequest().body(new Response<>(new ErrorMessage("error"), Status.FAILED));

        return new  ResponseEntity<>(new Response<>(result.get(), Status.SUCCESS), HttpStatus.CREATED);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getOrderAndProductName(@RequestParam Integer order_id){

        Optional<OrderDetailProductNameDto> result = orderService.getOrderAndProductName(order_id);

        if (result.isEmpty())
            return ResponseEntity.badRequest().body(new Response<>(new ErrorMessage("order not found"), Status.FAILED));

        return ResponseEntity.status(200).body(result.get());

    }

}
