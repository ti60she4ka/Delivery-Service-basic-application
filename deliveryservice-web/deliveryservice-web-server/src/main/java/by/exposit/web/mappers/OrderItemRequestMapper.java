package by.exposit.web.mappers;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.OrderItemDto;
import by.exposit.web.requests.OrderItemRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderItemRequestMapper {

  @Mapping(target = "article", source = "articleId", qualifiedByName = "articleIdToArticle")
  OrderItemDto toDto(OrderItemRequest orderItemRequest);

  @Named("articleIdToArticle")
  default ArticleDto articleIdToArticle(Long articleId){
    ArticleDto articleDto = new ArticleDto();
    articleDto.setId(articleId);
    return articleDto;
  }
}
