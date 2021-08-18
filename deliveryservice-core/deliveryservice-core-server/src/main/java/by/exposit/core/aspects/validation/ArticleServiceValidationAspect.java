package by.exposit.core.aspects.validation;

import by.exposit.core.annotations.article.ArticleIdExists;
import by.exposit.core.aspects.benchmark.BenchmarkAspect;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.repositories.ArticleRepository;
import java.lang.reflect.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
public class ArticleServiceValidationAspect {

  private final ArticleRepository articleRepository;

  private static final String ENTITY_TYPE = "Article";

  public ArticleServiceValidationAspect(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  @Pointcut(value = "execution(* by.exposit.core.services.article.ArticleServiceImpl.*(..))")
  public void anyMethodInArticleService() {
  }

  @Before("anyMethodInArticleService() && @annotation(Validate)")
  public void validateArticleServiceParameters(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    Parameter[] parameters = ((MethodSignature) joinPoint.getSignature()).getMethod()
        .getParameters();

    for (int i = 0; i < parameters.length; i++) {
      if (parameters[i].isAnnotationPresent(ArticleIdExists.class)
          && parameters[i].getType() == Long.class) {

        executeArticleIdExistsLogic((Long) args[i]);
      }
    }
  }

  private void executeArticleIdExistsLogic(Long id) {
    if (!articleRepository.existsById(id)) {
      throw new EntityNotFoundException(ENTITY_TYPE, id);
    }
  }
}