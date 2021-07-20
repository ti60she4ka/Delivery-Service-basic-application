package by.exposit.repositories.product;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.ProductCannotBeAddedException;
import by.exposit.model.entities.Product;
import by.exposit.repositories.AbstractRepositoryImpl;
import by.exposit.storages.ProductDataStorage;

public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product>
    implements ProductRepository {

  private final ProductDataStorage productDataStorage;

  public ProductRepositoryImpl(ProductDataStorage productDataStorage) {
    super(productDataStorage);
    this.productDataStorage = productDataStorage;
    entityType = "Product";
  }

  @Override
  public void create(Product entity) throws EntityCannotBeAddedException {
    if (productDataStorage.getEntities().stream()
        .anyMatch(item -> item.getName().equalsIgnoreCase(entity.getName()))) {

      throw new ProductCannotBeAddedException(entity.getName());
    }

    super.create(entity);
  }
}
