package uz.apelsin.task.payload;

import lombok.Data;

@Data
public class CustomerDto {

    private Integer id;

    private String name;

    private String county;

    private String address;

    private String phone;

}
