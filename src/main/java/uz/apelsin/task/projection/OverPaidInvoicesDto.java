package uz.apelsin.task.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverPaidInvoicesDto {

    private Integer invoiceId;

    private Double reimbursedAmount;

}
