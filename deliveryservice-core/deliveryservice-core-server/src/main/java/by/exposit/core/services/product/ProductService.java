package by.exposit.core.services.product;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.filter.specifications.ProductSpecificationFilter;
import by.exposit.core.model.entities.Product;
import by.exposit.core.services.AbstractService;
import java.util.Collection;

public interface ProductService extends AbstractService<Product, ProductDto> {

  Collection<ArticleDto> getArticlesByProductId(Long id);

  Collection<ProductDto> getAll(ProductSpecificationFilter filter);
}
