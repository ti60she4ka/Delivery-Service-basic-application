package by.exposit.core.mappers.article;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Article;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends BaseMapper<Article, ArticleDto> {

  @Override
  ArticleDto toDto(Article article);

  @Override
  Article toEntity(ArticleDto articleDto);

  @Override
  Collection<ArticleDto> toDtoCollection(Collection<Article> articleCollection);

  @Override
  Collection<Article> toEntityCollection(Collection<ArticleDto> articleDtoCollection);
}
