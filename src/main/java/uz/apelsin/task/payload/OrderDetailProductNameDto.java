package uz.apelsin.task.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailProductNameDto {

    private Integer id;

    private LocalDate date;

    private CustomerDto customerDto;

    private String productName;

}
