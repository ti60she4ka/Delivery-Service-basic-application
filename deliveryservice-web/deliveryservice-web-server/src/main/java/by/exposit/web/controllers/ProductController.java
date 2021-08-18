package by.exposit.web.controllers;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.filter.specifications.ProductSpecificationFilter;
import by.exposit.core.services.product.ProductService;
import by.exposit.web.mappers.ProductRequestMapper;
import by.exposit.web.requests.ProductRequest;
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
@RequestMapping("products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private ProductRequestMapper mapper;

  @PostMapping()
  public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductRequest productRequest){
    return new ResponseEntity<>(
        productService.create(mapper.toDto(productRequest)),
        HttpStatus.CREATED
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getById(@PathVariable Long id){
    return new ResponseEntity<>(
        productService.getById(id),
        HttpStatus.OK
    );
  }

  @GetMapping()
  public ResponseEntity<Collection<ProductDto>> getAll(ProductSpecificationFilter filter){
    return new ResponseEntity<>(
        productService.getAll(filter),
        HttpStatus.OK
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable Long id,
      @RequestBody @Valid ProductRequest productRequest){

    productService.update(mapper.toDtoWithId(productRequest, id));
    return ResponseBody.successOperation();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteById(@PathVariable Long id){
    productService.deleteById(id);
    return ResponseBody.successOperation();
  }

  @GetMapping("/{id}/articles")
  public ResponseEntity<Collection<ArticleDto>> getArticlesByProductId(@PathVariable Long id){
    return new ResponseEntity<>(
        productService.getArticlesByProductId(id),
        HttpStatus.OK
    );
  }
}
