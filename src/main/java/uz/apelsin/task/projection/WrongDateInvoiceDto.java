package uz.apelsin.task.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrongDateInvoiceDto {

    private Integer id;

    private LocalDate issued;

    private Integer orderId;

    private LocalDate date;

}
