package uz.apelsin.task.service.impl;

import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Invoice;
import uz.apelsin.task.repository.InvoiceRepository;
import uz.apelsin.task.service.InvoiceService;

import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<Invoice> findById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }
}
