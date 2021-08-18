package by.exposit.core.services;

import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.BaseEntity;
import by.exposit.core.repositories.AbstractRepository;
import java.util.Collection;

public abstract class AbstractServiceImpl<T extends BaseEntity, E> implements AbstractService<T, E> {

  protected final AbstractRepository<T> abstractRepository;

  protected final BaseMapper<T, E> mapper;

  protected AbstractServiceImpl(AbstractRepository<T> abstractRepository, BaseMapper<T, E> mapper) {
    this.abstractRepository = abstractRepository;
    this.mapper = mapper;
  }

  @Override
  public E create(E entityDto) {
    return mapper.toDto(abstractRepository.create(mapper.toEntity(entityDto)));
  }

  @Override
  public Collection<E> getAll() {
    return mapper.toDtoCollection(abstractRepository.getAll());
  }

  @Override
  public void deleteById(Long id) {
    abstractRepository.deleteById(id);
  }

  @Override
  public E getById(Long id) {
    return mapper.toDto(abstractRepository.getById(id));
  }

  @Override
  public void update(E entityDto) {
    abstractRepository.update(mapper.toEntity(entityDto));
  }
}
