package uz.apelsin.task.payload;

import lombok.Data;

@Data
public class OrderRequestDto {

    private Integer customerId;

    private Integer productId;

    private Integer quantity;

}
