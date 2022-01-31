package uz.apelsin.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Detail {
    @Transient
    private static final String seqName = "detail_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = seqName)
    @SequenceGenerator(sequenceName = seqName, name = seqName, allocationSize = 1)
    private Integer id;

    @ManyToOne
    private Product product;

    @OneToOne
    private Orders orders;

    private Integer quantity;
}
