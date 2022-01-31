package uz.apelsin.task.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Invoice;
import uz.apelsin.task.projection.OverPaidInvoicesDto;
import uz.apelsin.task.projection.WrongDateInvoiceDto;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "select * from invoice where due<issued", nativeQuery = true)
    Page<Invoice> findExpiredInvoices(Pageable pageable);

    //2
    @Query(value = "SELECT new uz.apelsin.task.projection.WrongDateInvoiceDto(i.id, i.issued, i.orders.id, o.date) from Invoice i join orders o on o.id = i.orders.id where o.date>i.issued")
    Page<WrongDateInvoiceDto> findWrongDateInvoices(Pageable pageable);

    //6
    @Query(value ="SELECT new uz.apelsin.task.projection.OverPaidInvoicesDto(p.invoice.id, sum(p.amount)) from Payment p group by p.invoice.id")
    List<OverPaidInvoicesDto> findOverPaidInvoices();

}
