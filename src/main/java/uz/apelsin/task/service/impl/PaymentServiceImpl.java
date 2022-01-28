package uz.apelsin.task.service.impl;

import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Invoice;
import uz.apelsin.task.model.Payment;
import uz.apelsin.task.payload.PaymentDto;
import uz.apelsin.task.repository.PaymentRepository;
import uz.apelsin.task.service.InvoiceService;
import uz.apelsin.task.service.PaymentService;
import uz.apelsin.task.service.mapper.PaymentMapper;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final InvoiceService invoiceService;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper, InvoiceService invoiceService) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.invoiceService = invoiceService;
    }

    @Override
    public PaymentDto makePayment(Integer invoiceId) {

        Optional<Invoice> invoice = invoiceService.findById(invoiceId);

        Payment payment = new Payment();
        payment.setInvoice(invoice.get());
        payment.setAmount(invoice.get().getAmount());
        payment.setTime(LocalDateTime.now());

        return paymentMapper.toDto(save(payment));
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<PaymentDto> getPaymentDto(Integer id) {
        return getPaymentEntity(id).map(paymentMapper::toDto);
    }

    @Override
    public Optional<Payment> getPaymentEntity(Integer id) {
        return paymentRepository.findById(id);
    }
}
