package by.exposit.core.services.product;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.model.entities.Product;
import by.exposit.core.services.AbstractService;
import java.util.Collection;

public interface ProductService extends AbstractService<Product, ProductDto> {

  Collection<ArticleDto> getArticlesByProductId(Long id);
}
