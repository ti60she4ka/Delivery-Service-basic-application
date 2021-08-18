package by.exposit.core.aspects.validation;

import by.exposit.core.annotations.order.OrderIdExists;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.repositories.OrderRepository;
import java.lang.reflect.Parameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
public class OrderServiceValidationAspect {

  private final OrderRepository orderRepository;

  private static final String ENTITY_TYPE = "Order";

  public OrderServiceValidationAspect(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Pointcut(value = "execution(* by.exposit.core.services.order.OrderServiceImpl.*(..))")
  public void anyMethodInOrderService() {
  }

  @Before("anyMethodInOrderService() && @annotation(Validate)")
  public void validateOrderServiceParameters(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    Parameter[] parameters = ((MethodSignature) joinPoint.getSignature()).getMethod()
        .getParameters();

    for (int i = 0; i < parameters.length; i++) {
      if (parameters[i].isAnnotationPresent(OrderIdExists.class)
          && parameters[i].getType() == Long.class) {

        executeOrderIdExistsLogic((Long) args[i]);
      }
    }
  }

  private void executeOrderIdExistsLogic(Long id) {
    if (!orderRepository.existsById(id)) {
      throw new EntityNotFoundException(ENTITY_TYPE, id);
    }
  }
}
