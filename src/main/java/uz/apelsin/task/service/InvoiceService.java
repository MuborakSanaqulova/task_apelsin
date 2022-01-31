package uz.apelsin.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.apelsin.task.model.Invoice;
import uz.apelsin.task.payload.InvoiceDto;
import uz.apelsin.task.projection.OverPaidInvoicesDto;
import uz.apelsin.task.projection.WrongDateInvoiceDto;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Integer invoiceId);

    Page<InvoiceDto> getExpiredInvoices(Pageable pageable);

    Page<Invoice> getInvoicesEntity(Pageable pageable);

    Page<WrongDateInvoiceDto> getWrongDateInvoices(Pageable pageable);

    List<OverPaidInvoicesDto> getOverpaidInvoices();
}
