package uz.apelsin.task.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.apelsin.task.payload.CustomerDto;
import uz.apelsin.task.payload.InvoiceDto;
import uz.apelsin.task.payload.OrderDto;
import uz.apelsin.task.projection.*;
import uz.apelsin.task.service.CustomerService;
import uz.apelsin.task.service.InvoiceService;
import uz.apelsin.task.service.OrderService;
import uz.apelsin.task.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/main")
public class MainController {

    private final InvoiceService invoiceService;
    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;

    public MainController(InvoiceService invoiceService, OrderService orderService, CustomerService customerService, ProductService productService) {
        this.invoiceService = invoiceService;
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }


    //1
    @GetMapping("/expired_invoices")
    public ResponseEntity<?> getExpiredInvoices(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<InvoiceDto> invoiceDtos = invoiceService.getExpiredInvoices(pageable);
        return ResponseEntity.ok(invoiceDtos);
    }

    //2 error
    @GetMapping("/wrong_date_invoices")
    public ResponseEntity<?> getWrongDateInvoices(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<WrongDateInvoiceDto> invoiceDtos = invoiceService.getWrongDateInvoices(pageable);
        return ResponseEntity.ok(invoiceDtos);
    }

    //3
    @GetMapping("/orders_without_details")
    public ResponseEntity<?> getOrdersWithoutDetails(Pageable pageable) {
        Page<OrderDto> orderDtoPage = orderService.getOrdersWithoutDetails(pageable);
        return ResponseEntity.ok(orderDtoPage);
    }

    //4
    @GetMapping("/customers_without_orders")
    public ResponseEntity<?> getCustomersWithoutOrders(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<CustomerDto> customerDtoPage = customerService.getCustomersWithoutOrders(pageable);
        return ResponseEntity.ok(customerDtoPage);
    }

    //5
    @GetMapping("/customers_last_orders")
    public ResponseEntity<?> getCustomersLastOrders(){
        List<CustomerLastOrdersProjection> result = customerService.getCustomersLastOrders();
        return ResponseEntity.ok(result);
    }

    //6
    @GetMapping("/overpaid_invoices")
    public ResponseEntity<?> getOverpaidInvoices(){
        List<OverPaidInvoicesProjection> result = invoiceService.getOverpaidInvoices();
        return ResponseEntity.ok(result);
    }

    //7
    @GetMapping("/high_demand_products")
    public ResponseEntity<?> getHighDemandProducts(){
        List<HighDemandProductsProjection> result = productService.getHighDemandProducts();
        return ResponseEntity.ok(result);
    }

    //8
    @GetMapping("/bulk_products")
    public ResponseEntity<?> getBulkProducts(){
        List<BulkProductsProjection> result = productService.getBulkProducts();
        return ResponseEntity.ok(result);
    }

    //9
    @GetMapping("/number_of_products_in_year")
    public ResponseEntity<?> getNumberOfProductsInYear(){
        List<NumberOfProductsInYearProjection> result = customerService.getNumberOfProductsInYear();
        return ResponseEntity.ok(result);
    }

    //10
    @GetMapping("/orders_without_invoices")
    public ResponseEntity<?> getOrdersWithoutInvoices(){
        List<OrdersWithoutInvoicesProjection> result = orderService.getOrdersWithoutInvoices();
        return ResponseEntity.ok(result);
    }


}
