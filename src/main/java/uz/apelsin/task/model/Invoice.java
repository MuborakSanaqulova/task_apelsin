package uz.apelsin.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice {

    @Transient
    private static final String seqName = "invoice_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = seqName)
    @SequenceGenerator(sequenceName = seqName, name = seqName, allocationSize = 1)
    private Integer id;

    @OneToOne
    private Order order;

    private Double amount;

    private LocalDate issued;

    private LocalDate due;

}
