package by.exposit.core.aspects.validation;

import by.exposit.core.annotations.category.CategoryIdExists;
import by.exposit.core.annotations.category.CategoryNameNotOccupied;
import by.exposit.core.dto.CategoryDto;
import by.exposit.core.exceptions.CategoryAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.repositories.CategoryRepository;
import java.lang.reflect.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
public class CategoryServiceValidationAspect {

  private final CategoryRepository categoryRepository;

  private static final String ENTITY_TYPE = "Category";

  public CategoryServiceValidationAspect(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Pointcut(value = "execution(* by.exposit.core.services.category.CategoryServiceImpl.*(..))")
  public void anyMethodInCategoryService() {
  }

  @Before("anyMethodInCategoryService() && @annotation(Validate)")
  public void validateCategoryServiceParameters(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    Parameter[] parameters = ((MethodSignature) joinPoint.getSignature()).getMethod()
        .getParameters();

    for (int i = 0; i < parameters.length; i++) {
      if (parameters[i].isAnnotationPresent(CategoryIdExists.class)
          && parameters[i].getType() == Long.class) {

        executeCategoryIdExistsLogic((Long) args[i]);
      }

      if (parameters[i].isAnnotationPresent(CategoryNameNotOccupied.class)
          && parameters[i].getType() == CategoryDto.class) {

        executeCategoryNameNotOccupiedLogic((CategoryDto) args[i]);
      }
    }
  }

  private void executeCategoryIdExistsLogic(Long id) {
    if (!categoryRepository.existsById(id)) {
      throw new EntityNotFoundException(ENTITY_TYPE, id);
    }
  }

  private void executeCategoryNameNotOccupiedLogic(CategoryDto categoryDto) {
    if (categoryDto.getId() == null && categoryRepository.existsByName(categoryDto.getName())) {
      throw new CategoryAlreadyExistsException(categoryDto.getName());
    }
    if (categoryDto.getId() != null && categoryRepository.existsByNameAndIdIsNot(
        categoryDto.getName(), categoryDto.getId())) {
      throw new CategoryAlreadyExistsException(categoryDto.getName());
    }
  }
}
