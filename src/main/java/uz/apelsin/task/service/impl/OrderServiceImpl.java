package uz.apelsin.task.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.apelsin.task.model.*;
import uz.apelsin.task.payload.OrderDetailProductNameDto;
import uz.apelsin.task.payload.OrderDto;
import uz.apelsin.task.payload.OrderRequestDto;
import uz.apelsin.task.payload.OrderResponseDto;
import uz.apelsin.task.projection.OrdersWithoutInvoicesProjection;
import uz.apelsin.task.repository.OrderRepository;
import uz.apelsin.task.service.*;
import uz.apelsin.task.service.mapper.CustomerMapper;
import uz.apelsin.task.service.mapper.OrderMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerService customerService;
    private final ProductService productService;
    private final InvoiceService invoiceService;
    private final DetailService detailService;
    private final CustomerMapper customerMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CustomerService customerService, ProductService productService, InvoiceService invoiceService, DetailService detailService, CustomerMapper customerMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerService = customerService;
        this.productService = productService;
        this.invoiceService = invoiceService;
        this.detailService = detailService;
        this.customerMapper = customerMapper;
    }

    @Override
    public Optional<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto) {

        Optional<Product> product = productService.findById(orderRequestDto.getProductId());
        Optional<Customer> customer = customerService.findById(orderRequestDto.getCustomerId());
        if (product.isEmpty() || customer.isEmpty())
            return Optional.empty();

        Orders orders = new Orders();
        orders.setDate(LocalDate.now());
        customer.ifPresent(orders::setCustomer);

        Orders finalOrders = save(orders);

        Invoice invoice = new Invoice();
        invoice.setOrders(finalOrders);
        invoice.setAmount(product.get().getPrice() * orderRequestDto.getQuantity());
        invoice.setIssued(LocalDate.now());
        invoice.setDue(LocalDate.now().plusDays(10));

        Invoice finalInvoice = invoiceService.save(invoice);

        Detail detail = new Detail();
        detail.setQuantity(orderRequestDto.getQuantity());
        detail.setProduct(product.get());
        detail.setOrders(finalOrders);

        detailService.save(detail);

        return Optional.of(new OrderResponseDto(finalInvoice.getId()));
    }

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Optional<OrderDetailProductNameDto> getOrderAndProductName(Integer order_id) {

        Optional<Orders> optionalOrder = orderRepository.findById(order_id);
        Optional<Product> productByOrderId = productService.findProductByOrderId(order_id);

        if (productByOrderId.isEmpty() || optionalOrder.isEmpty())
            return Optional.empty();

        OrderDetailProductNameDto orderDetailProductNameDto = new OrderDetailProductNameDto();
        orderDetailProductNameDto.setDate(optionalOrder.get().getDate());
        orderDetailProductNameDto.setId(optionalOrder.get().getId());
        orderDetailProductNameDto.setProductName(productByOrderId.get().getName());
        orderDetailProductNameDto.setCustomerDto(customerMapper.toDto(optionalOrder.get().getCustomer()));

        return Optional.of(orderDetailProductNameDto);
    }

    // task 3
    @Override
    public Page<OrderDto> getOrdersWithoutDetails(Pageable pageable) {

        Page<Orders> orderWithoutDetails = orderRepository.findOrderWithoutDetails(pageable);

        return orderWithoutDetails.map(orderMapper::toDto);
    }


    //task 10
    @Override
    public List<OrdersWithoutInvoicesProjection> getOrdersWithoutInvoices() {
        return orderRepository.getOrdersWithoutInvoices();
    }


}
