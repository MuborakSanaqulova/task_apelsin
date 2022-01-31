package uz.apelsin.task.projection;

import java.time.LocalDate;

public interface CustomerLastOrdersProjection {

    Integer getCustomerId();

    String getCustomerName();

    LocalDate getOrderDate();

}
