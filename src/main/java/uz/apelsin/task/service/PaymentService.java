package uz.apelsin.task.service;

import uz.apelsin.task.model.Payment;
import uz.apelsin.task.payload.PaymentDto;
import uz.apelsin.task.payload.PaymentRequestDto;

import java.util.Optional;

public interface PaymentService {

    PaymentDto makePayment(Integer invoiceId);

    Payment save(Payment payment);

    Optional<PaymentDto> getPaymentDto(Integer id);

    Optional<Payment> getPaymentEntity(Integer id);
}
