package by.exposit.persistence.specifications;

import by.exposit.core.filter.specifications.ProductSpecificationFilter;
import by.exposit.persistence.entities.ProductEntity;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

  private ProductSpecification() {
  }

  public static Specification<ProductEntity> filter(ProductSpecificationFilter filter) {
    if (filter == null) {
      return null;
    }

    return (root, query, builder) -> {
      Predicate finalPredicate = builder.conjunction();

      if (filter.getName() != null) {
        Predicate predicate = builder.like(root.get("name"), "%" + filter.getName() + "%");
        finalPredicate = builder.and(finalPredicate, predicate);
      }

      if (filter.getAttribute() != null) {
        if (filter.getAttribute().getName() != null) {
          Predicate predicate = builder.like(root.join("attributes", JoinType.LEFT).get("name"),
              filter.getAttribute().getName());
          finalPredicate = builder.and(finalPredicate, predicate);
        }
      }

      return finalPredicate;
    };
  }
}
