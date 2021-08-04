package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.Article;
import by.exposit.persistence.entities.ArticleEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticlePersistenceMapper {

  ArticleEntity toPersistenceEntity(Article article);

  Article toEntity(ArticleEntity articleEntity);

  Collection<ArticleEntity> toPersistenceEntityCollection(Collection<Article> articles);

  Collection<Article> toEntityCollection(Collection<ArticleEntity> articleEntityCollection);
}
