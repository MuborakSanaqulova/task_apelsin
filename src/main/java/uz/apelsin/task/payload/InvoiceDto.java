package uz.apelsin.task.payload;

import lombok.Data;
import uz.apelsin.task.model.Order;

import java.time.LocalDate;

@Data
public class InvoiceDto {

    private Integer id;

    private OrderDto orderDto;

    private Double amount;

    private LocalDate issued;

    private LocalDate due;

}
