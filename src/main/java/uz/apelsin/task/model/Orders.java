package uz.apelsin.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Orders {

    @Transient
    private static final String seqName = "order_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = seqName)
    @SequenceGenerator(sequenceName = seqName, name = seqName, allocationSize = 1)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    private Customer customer;

}
