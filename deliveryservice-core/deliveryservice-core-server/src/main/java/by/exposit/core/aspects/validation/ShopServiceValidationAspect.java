package by.exposit.core.aspects.validation;

import by.exposit.core.annotations.shop.ShopIdExists;
import by.exposit.core.dto.CategoryDto;
import by.exposit.core.exceptions.CategoryAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.repositories.ShopRepository;
import java.lang.reflect.Parameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
public class ShopServiceValidationAspect {

  private final ShopRepository shopRepository;

  private static final String ENTITY_TYPE = "Shop";

  public ShopServiceValidationAspect(ShopRepository shopRepository) {
    this.shopRepository = shopRepository;
  }

  @Pointcut(value = "execution(* by.exposit.core.services.shop.ShopServiceImpl.*(..))")
  public void anyMethodInShopService() {
  }

  @Before("anyMethodInShopService() && @annotation(Validate)")
  public void validateShopServiceParameters(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    Parameter[] parameters = ((MethodSignature) joinPoint.getSignature()).getMethod()
        .getParameters();

    for (int i = 0; i < parameters.length; i++) {
      if (parameters[i].isAnnotationPresent(ShopIdExists.class)
          && parameters[i].getType() == Long.class) {

        executeShopIdExistsLogic((Long) args[i]);
      }
    }
  }

  private void executeShopIdExistsLogic(Long id) {
    if (!shopRepository.existsById(id)) {
      throw new EntityNotFoundException(ENTITY_TYPE, id);
    }
  }
}
