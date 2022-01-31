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
import uz.apelsin.task.projection.OverPaidInvoicesDto;
import uz.apelsin.task.projection.WrongDateInvoiceDto;
import uz.apelsin.task.service.CustomerService;
import uz.apelsin.task.service.InvoiceService;
import uz.apelsin.task.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final OrderService orderService;
    private final CustomerService customerService;

    public InvoiceController(InvoiceService invoiceService, OrderService orderService, CustomerService customerService) {
        this.invoiceService = invoiceService;
        this.orderService = orderService;
        this.customerService = customerService;
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
//    @GetMapping("/customers_last_orders")
//    public ResponseEntity<?> getCustomersLastOrders(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
//        Page<CustomerDto>
//    }

    //6 error
    @GetMapping("/overpaid_invoices")
    public ResponseEntity<?> getOverpaidInvoices(){
        List<OverPaidInvoicesDto> invoiceDtos = invoiceService.getOverpaidInvoices();

        return ResponseEntity.ok(invoiceDtos);
    }



}
