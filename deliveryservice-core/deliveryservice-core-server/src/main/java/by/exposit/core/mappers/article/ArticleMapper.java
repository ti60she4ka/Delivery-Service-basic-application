package by.exposit.core.mappers.article;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Article;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper extends BaseMapper<Article, ArticleDto> {

  ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

  @Override
  ArticleDto toDto(Article article);

  @Override
  @Mapping(target = "shop", ignore = true)
  @Mapping(target = "product", ignore = true)
  Article toEntity(ArticleDto articleDto);

  @Override
  Collection<ArticleDto> toDtoCollection(Collection<Article> articleCollection);

  @Override
  Collection<Article> toEntityCollection(Collection<ArticleDto> articleDtoCollection);
}
