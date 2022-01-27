package uz.apelsin.task.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.apelsin.task.model.Invoice;
import uz.apelsin.task.payload.InvoiceDto;
import uz.apelsin.task.utility.EntityMapper;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface InvoiceMapper extends EntityMapper<InvoiceDto, Invoice> {

    @Mapping(target = "orderDto", source = "order")
    InvoiceDto toDto(Invoice invoice);

    @Mapping(target = "order", source = "orderDto")
    Invoice toEntity(InvoiceDto invoiceDto);

}
