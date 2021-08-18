package by.exposit.web.controllers;

import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.services.category.CategoryService;
import by.exposit.web.mappers.CategoryRequestMapper;
import by.exposit.web.requests.CategoryRequest;
import by.exposit.web.response.ResponseBody;
import java.util.Collection;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private CategoryRequestMapper mapper;

  @PostMapping()
  public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryRequest categoryRequest) {
    return new ResponseEntity<>(
        categoryService.create(mapper.toDto(categoryRequest)),
        HttpStatus.CREATED
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
    return new ResponseEntity<>(
        categoryService.getById(id),
        HttpStatus.OK
    );
  }

  @GetMapping()
  public ResponseEntity<Collection<CategoryDto>> getAll() {
    return new ResponseEntity<>(
        categoryService.getAll(),
        HttpStatus.OK
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable Long id,
      @RequestBody @Valid CategoryRequest categoryRequest) {

    categoryService.update(mapper.toDtoWithId(categoryRequest, id));
    return ResponseBody.successOperation();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteById(@PathVariable Long id) {
    categoryService.deleteById(id);
    return ResponseBody.successOperation();
  }

  @GetMapping("/{id}/products")
  public ResponseEntity<Collection<ProductDto>> getProductsByCategoryId(@PathVariable Long id){
    return new ResponseEntity<>(
        categoryService.getProductsByCategoryId(id),
        HttpStatus.OK
    );
  }
}
