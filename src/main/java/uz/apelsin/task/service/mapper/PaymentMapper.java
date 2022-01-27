package uz.apelsin.task.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.apelsin.task.model.Payment;
import uz.apelsin.task.payload.PaymentDto;
import uz.apelsin.task.utility.EntityMapper;

@Mapper(componentModel = "spring", uses = InvoiceMapper.class)
public interface PaymentMapper extends EntityMapper<PaymentDto, Payment> {

    @Mapping(target = "invoiceDto", source = "invoice")
    PaymentDto toDto(Payment payment);

    @Mapping(target = "invoice", source = "invoiceDto")
    Payment toEntity(PaymentDto paymentDto);

}
