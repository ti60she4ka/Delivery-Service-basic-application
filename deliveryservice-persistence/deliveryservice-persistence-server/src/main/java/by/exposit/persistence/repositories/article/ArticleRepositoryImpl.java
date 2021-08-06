package by.exposit.persistence.repositories.article;

import by.exposit.core.model.entities.Article;
import by.exposit.core.repositories.ArticleRepository;
import by.exposit.persistence.mappers.ArticlePersistenceMapper;
import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

public class ArticleRepositoryImpl implements ArticleRepository {

  private final ArticleJpaRepository repository;
  private final ArticlePersistenceMapper mapper;

  public ArticleRepositoryImpl(ArticleJpaRepository repository, ArticlePersistenceMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  @Transactional
  public Article create(Article article) {
    return mapper.toEntity(repository.save(mapper.toPersistenceEntity(article)));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Article> getAll() {
    return mapper.toEntityCollection(repository.findAll());
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(Article article) {
    repository.save(mapper.toPersistenceEntity(article));
  }

  @Override
  @Transactional(readOnly = true)
  public Article getById(Long id) {
    return mapper.toEntity(repository.getById(id));
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }
}
