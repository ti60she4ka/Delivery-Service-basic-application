package by.exposit.core.services.category;

import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.model.entities.Category;
import by.exposit.core.services.AbstractService;
import java.util.Collection;

public interface CategoryService extends AbstractService<Category, CategoryDto> {

  Collection<ProductDto> getProductsByCategoryId(Long id);
}
