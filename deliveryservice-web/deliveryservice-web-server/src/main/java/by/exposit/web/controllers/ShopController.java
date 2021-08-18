package by.exposit.web.controllers;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.ShopDto;
import by.exposit.core.services.shop.ShopService;
import by.exposit.web.mappers.ShopRequestMapper;
import by.exposit.web.requests.ShopRequest;
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
@RequestMapping("shops")
public class ShopController {

  @Autowired
  private ShopService shopService;

  @Autowired
  private ShopRequestMapper mapper;

  @PostMapping()
  public ResponseEntity<ShopDto> create(@RequestBody @Valid ShopRequest shopRequest) {
    return new ResponseEntity<>(
        shopService.create(mapper.toDto(shopRequest)),
        HttpStatus.CREATED
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<ShopDto> getById(@PathVariable Long id) {
    return new ResponseEntity<>(
        shopService.getById(id),
        HttpStatus.OK
    );
  }

  @GetMapping()
  public ResponseEntity<Collection<ShopDto>> getAll() {
    return new ResponseEntity<>(
        shopService.getAll(),
        HttpStatus.OK
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable Long id,
      @RequestBody @Valid ShopRequest shopRequest) {

    shopService.update(mapper.toDtoWithId(shopRequest, id));
    return ResponseBody.successOperation();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteById(@PathVariable Long id) {
    shopService.deleteById(id);
    return ResponseBody.successOperation();
  }

  @GetMapping("/{id}/articles")
  public ResponseEntity<Collection<ArticleDto>> getArticlesByShopId(@PathVariable Long id){
    return new ResponseEntity<>(
        shopService.getArticlesByShopId(id),
        HttpStatus.OK
    );
  }
}
