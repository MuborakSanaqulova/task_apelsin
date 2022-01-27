package uz.apelsin.task.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.apelsin.task.common.Response;
import uz.apelsin.task.model.enums.Status;
import uz.apelsin.task.payload.CategoryDto;
import uz.apelsin.task.service.CategoryService;

import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<CategoryDto> categoryDtos = categoryService.findAllDto(pageable);
        return ResponseEntity.ok(new Response(categoryDtos, Status.SUCCESS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Optional<CategoryDto> categoryDto = categoryService.getOneDto(id);

        if (categoryDto.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");

        return ResponseEntity.ok(categoryDto);

    }
}
