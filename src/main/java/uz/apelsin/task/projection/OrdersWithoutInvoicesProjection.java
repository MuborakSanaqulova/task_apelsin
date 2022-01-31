package uz.apelsin.task.projection;

import java.time.LocalDate;

public interface OrdersWithoutInvoicesProjection {

    Integer getOrderId();

    LocalDate getOrderDate();

    Double getTotalPrice();

    Integer getQuantity();

    Double getUnitPrice();
}
