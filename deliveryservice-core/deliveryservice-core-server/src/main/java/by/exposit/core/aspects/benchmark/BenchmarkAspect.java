package by.exposit.core.aspects.benchmark;

import by.exposit.core.exceptions.EntityAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.ServerException;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
@Order(1)
public class BenchmarkAspect {

  private static final int MAX_EXECUTION_TIME = 150;

  private final Environment environment;

  public BenchmarkAspect(Environment environment) {
    this.environment = environment;
  }

  @Around("execution(* by.exposit.core.services.*.*(..)) || execution(* by.exposit.core.services.*.*.*(..))")
  public Object benchmarkServiceMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    Object result;
    try {
      result = proceedingJoinPoint.proceed();
    } catch (EntityNotFoundException | EntityAlreadyExistsException exception) {
      log.debug("EXCEPTION WAS FOUND. INFO: {} -> {}", exception.getClass(),
          exception.getMessage());
      throw exception;
    } catch (Exception exception) {
      log.warn("UNSUPPORTED EXCEPTION WAS FOUND. INFO: {} -> {}", exception.getClass(),
          exception.getMessage());
      throw new ServerException();
    } finally {
      stopWatch.stop();
      if (stopWatch.getLastTaskTimeMillis() > MAX_EXECUTION_TIME) {
        logWarning(stopWatch.getLastTaskTimeMillis(), proceedingJoinPoint);
      }
    }

    return result;
  }

  private void logWarning(long executionTime, ProceedingJoinPoint proceedingJoinPoint) {
    List<String> activeProfiles = List.of(environment.getActiveProfiles());
    if (activeProfiles.contains("dev")) {
      log.warn("Execution time of method is more than 150 ms ({} ms). METHOD INFO: {}",
          executionTime, getMethodInfo(proceedingJoinPoint));
    } else if (activeProfiles.contains("prod")) {
      log.debug("Execution time of method is more than 150 ms ({} ms). METHOD INFO: {}",
          executionTime, getMethodInfo(proceedingJoinPoint));
    }
  }

  private String getMethodInfo(ProceedingJoinPoint proceedingJoinPoint) {
    return "signature - " + proceedingJoinPoint.getSignature() +
        ", args - " + Arrays.toString(proceedingJoinPoint.getArgs());
  }
}
