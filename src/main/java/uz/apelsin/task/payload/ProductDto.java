package uz.apelsin.task.payload;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;

    private String name;

    private String description;

    private Double price;

    private String photo;

    private CategoryDto categoryDto;

}
