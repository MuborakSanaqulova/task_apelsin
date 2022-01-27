package uz.apelsin.task.payload;

import lombok.Data;

@Data
public class DetailDto {

    private Integer id;

    private OrderDto orderDto;

    private ProductDto productDto;

    private Integer quantity;

}
