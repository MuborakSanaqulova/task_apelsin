package uz.apelsin.task.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.apelsin.task.common.Response;
import uz.apelsin.task.model.enums.Status;
import uz.apelsin.task.payload.CategoryDto;
import uz.apelsin.task.payload.ProductDto;
import uz.apelsin.task.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ProductDto> productDtos = productService.findAllDto(pageable);
        return ResponseEntity.ok(new Response(productDtos, Status.SUCCESS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Optional<ProductDto> productDto = productService.getOneDto(id);

        if (productDto.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");

        return ResponseEntity.ok(productDto);

    }
}
