package uz.apelsin.task.service;

import uz.apelsin.task.model.Invoice;

import java.util.Optional;

public interface InvoiceService {

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Integer invoiceId);
}
