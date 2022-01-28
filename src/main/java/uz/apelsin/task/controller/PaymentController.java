package uz.apelsin.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.apelsin.task.common.ErrorMessage;
import uz.apelsin.task.common.Response;
import uz.apelsin.task.model.Invoice;
import uz.apelsin.task.model.enums.Status;
import uz.apelsin.task.payload.PaymentDto;
import uz.apelsin.task.payload.PaymentRequestDto;
import uz.apelsin.task.service.InvoiceService;
import uz.apelsin.task.service.PaymentService;

import java.util.Optional;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final InvoiceService invoiceService;

    public PaymentController(PaymentService paymentService, InvoiceService invoiceService) {
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<?> makePayment(@RequestBody PaymentRequestDto paymentRequestDto){

        Optional<Invoice> invoice = invoiceService.findById(paymentRequestDto.getInvoiceId());

        if (invoice.isEmpty())
            return ResponseEntity.badRequest().body(new Response<>(new ErrorMessage("invoice not found"), Status.FAILED));

        PaymentDto result = paymentService.makePayment(invoice.get().getId());

        return new  ResponseEntity<>(new Response<>(result, Status.SUCCESS), HttpStatus.CREATED);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getPayment(@RequestParam Integer id){

        Optional<PaymentDto> paymentDto = paymentService.getPaymentDto(id);

        if (paymentDto.isEmpty())
            return ResponseEntity.badRequest().body(new Response<>(new ErrorMessage("invoice not found"), Status.FAILED));

        return new  ResponseEntity<>(new Response<>(paymentDto.get(), Status.SUCCESS), HttpStatus.CREATED);

    }
}
