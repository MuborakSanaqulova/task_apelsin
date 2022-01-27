package uz.apelsin.task.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {

    private Integer id;

    private LocalDate date;

    private CustomerDto customerDto;
}
