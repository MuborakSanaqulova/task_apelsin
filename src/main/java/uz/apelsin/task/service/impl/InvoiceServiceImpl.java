package uz.apelsin.task.service.impl;

import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Invoice;
import uz.apelsin.task.payload.InvoiceDto;
import uz.apelsin.task.projection.OverPaidInvoicesDto;
import uz.apelsin.task.projection.WrongDateInvoiceDto;
import uz.apelsin.task.repository.InvoiceRepository;
import uz.apelsin.task.service.InvoiceService;
import uz.apelsin.task.service.mapper.InvoiceMapper;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<Invoice> findById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    @Override
    public Page<Invoice> getInvoicesEntity(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    //1

    @Override
    public Page<InvoiceDto> getExpiredInvoices(Pageable pageable) {

        Page<Invoice> expiredInvoices = invoiceRepository.findExpiredInvoices(pageable);

        return expiredInvoices.map(invoiceMapper::toDto);
    }

    //2
    @Override
    public Page<WrongDateInvoiceDto> getWrongDateInvoices(Pageable pageable) {

        Page<WrongDateInvoiceDto> wrongDateInvoices = invoiceRepository.findWrongDateInvoices(pageable);

        return wrongDateInvoices;
    }

    //6
    @Override
    public List<OverPaidInvoicesDto> getOverpaidInvoices() {

        return invoiceRepository.findOverPaidInvoices();
    }


}
