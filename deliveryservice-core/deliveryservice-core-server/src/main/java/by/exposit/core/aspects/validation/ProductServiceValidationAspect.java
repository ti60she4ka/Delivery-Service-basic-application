package by.exposit.core.aspects.validation;

import by.exposit.core.annotations.product.ProductIdExists;
import by.exposit.core.annotations.product.ProductNameNotOccupied;
import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.exceptions.CategoryAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.ProductAlreadyExistsException;
import by.exposit.core.repositories.ProductRepository;
import java.lang.reflect.Parameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
public class ProductServiceValidationAspect {

  private final ProductRepository productRepository;

  private static final String ENTITY_TYPE = "Product";

  public ProductServiceValidationAspect(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Pointcut(value = "execution(* by.exposit.core.services.product.ProductServiceImpl.*(..))")
  public void anyMethodInProductService() {
  }

  @Before("anyMethodInProductService() && @annotation(Validate)")
  public void validateProductServiceParameters(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    Parameter[] parameters = ((MethodSignature) joinPoint.getSignature()).getMethod()
        .getParameters();

    for (int i = 0; i < parameters.length; i++) {
      if (parameters[i].isAnnotationPresent(ProductIdExists.class)
          && parameters[i].getType() == Long.class) {

        executeProductIdExistsLogic((Long) args[i]);
      }

      if (parameters[i].isAnnotationPresent(ProductNameNotOccupied.class)
          && parameters[i].getType() == ProductDto.class) {

        executeProductNameNotOccupiedLogic((ProductDto) args[i]);
      }
    }
  }

  private void executeProductIdExistsLogic(Long id) {
    if (!productRepository.existsById(id)) {
      throw new EntityNotFoundException(ENTITY_TYPE, id);
    }
  }

  private void executeProductNameNotOccupiedLogic(ProductDto productDto) {
    if (productDto.getId() == null && productRepository.existsByName(productDto.getName())) {
      throw new ProductAlreadyExistsException(productDto.getName());
    }
    if (productDto.getId() != null && productRepository.existsByNameAndIdIsNot(
        productDto.getName(), productDto.getId())) {
      throw new ProductAlreadyExistsException(productDto.getName());
    }
  }
}
