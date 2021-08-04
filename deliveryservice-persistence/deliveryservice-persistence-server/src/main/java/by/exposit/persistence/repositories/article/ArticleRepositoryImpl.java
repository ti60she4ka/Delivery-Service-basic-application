package by.exposit.persistence.repositories.article;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.exceptions.EntityAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.Article;
import by.exposit.core.repositories.ArticleRepository;
import by.exposit.persistence.mappers.ArticlePersistenceMapper;
import java.util.Collection;

public class ArticleRepositoryImpl implements ArticleRepository {

  private final ArticleJpaRepository repository;
  private final ArticlePersistenceMapper mapper;

  public ArticleRepositoryImpl(ArticleJpaRepository repository, ArticlePersistenceMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Article create(Article article) {
    return mapper.toEntity(repository.save(mapper.toPersistenceEntity(article)));
  }

  @Override
  public Collection<Article> getAll() {
    return mapper.toEntityCollection(repository.findAll());
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void update(Article article) {
    repository.save(mapper.toPersistenceEntity(article));
  }

  @Override
  public Article getById(Long id) {
    return mapper.toEntity(repository.getById(id));
  }

  @Override
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }
}
