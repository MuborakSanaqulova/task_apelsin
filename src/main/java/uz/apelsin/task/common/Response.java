package uz.apelsin.task.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.apelsin.task.model.enums.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private T data;

    private Status status;

}
