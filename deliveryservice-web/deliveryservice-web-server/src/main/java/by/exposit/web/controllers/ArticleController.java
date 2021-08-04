package by.exposit.web.controllers;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.services.article.ArticleService;
import by.exposit.web.mappers.ArticleRequestMapper;
import by.exposit.web.requests.ArticleRequest;
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
@RequestMapping("articles")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @Autowired
  private ArticleRequestMapper mapper;

  @PostMapping()
  public ResponseEntity<ArticleDto> create(@RequestBody @Valid ArticleRequest articleRequest){
    return new ResponseEntity<>(
        articleService.create(mapper.toDto(articleRequest)),
        HttpStatus.OK
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<ArticleDto> getById(@PathVariable Long id){
    return new ResponseEntity<>(
        articleService.getById(id),
        HttpStatus.OK
    );
  }

  @GetMapping()
  public ResponseEntity<Collection<ArticleDto>> getAll(){
    return new ResponseEntity<>(
        articleService.getAll(),
        HttpStatus.OK
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable Long id,
      @RequestBody @Valid ArticleRequest articleRequest){

    articleService.update(mapper.toDtoWithId(articleRequest, id));
    return ResponseBody.successOperation();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteById(@PathVariable Long id){
    articleService.deleteById(id);
    return ResponseBody.successOperation();
  }
}
