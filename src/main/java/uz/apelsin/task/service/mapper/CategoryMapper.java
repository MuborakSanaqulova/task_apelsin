package uz.apelsin.task.service.mapper;

import org.mapstruct.Mapper;
import uz.apelsin.task.model.Category;
import uz.apelsin.task.payload.CategoryDto;
import uz.apelsin.task.utility.EntityMapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {
}
