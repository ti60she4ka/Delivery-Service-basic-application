package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.Product;
import by.exposit.persistence.entities.AttributeEntity;
import by.exposit.persistence.entities.ProductEntity;
import java.util.Collection;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AttributePersistenceMapper.class, CategoryPersistenceMapper.class})
public interface ProductPersistenceMapper {

  ProductEntity toPersistenceEntity(Product product);

  Product toEntity(ProductEntity productEntity);

  Collection<ProductEntity> toPersistenceEntityCollection(Collection<Product> products);

  Collection<Product> toEntityCollection(Collection<ProductEntity> productEntityCollection);

  @AfterMapping
  default void updateProductEntity(@MappingTarget ProductEntity productEntity){
    for(AttributeEntity attribute : productEntity.getAttributes()){
      attribute.setProduct(productEntity);
    }
  }
}
