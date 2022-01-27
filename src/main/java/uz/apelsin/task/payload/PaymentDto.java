package uz.apelsin.task.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {

    private Integer id;

    private LocalDateTime time;

    private Double amount;

    private InvoiceDto invoiceDto;
}
