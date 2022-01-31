package uz.apelsin.task.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceDto {

    private Integer id;

    private OrderDto orderDto;

    private Double amount;

    private LocalDate issued;

    private LocalDate due;

}
