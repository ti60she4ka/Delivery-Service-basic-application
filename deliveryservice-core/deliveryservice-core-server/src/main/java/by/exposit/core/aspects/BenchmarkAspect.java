package by.exposit.core.aspects;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class BenchmarkAspect {

  private final String profile;

  public BenchmarkAspect(String profile) {
    this.profile = profile;
  }

  @Around("execution(* by.exposit.core.services.*.*(..)) || execution(* by.exposit.core.services.*.*.*(..))")
  public Object benchmarkServiceMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long executionTime;
    long startTime = System.currentTimeMillis();

    Object result;
    try {
      result = proceedingJoinPoint.proceed();
    } finally {
      executionTime = System.currentTimeMillis() - startTime;
      if (executionTime > 150) {
        logWarning(executionTime, proceedingJoinPoint);
      }
    }

    return result;
  }

  private void logWarning(long executionTime, ProceedingJoinPoint proceedingJoinPoint) {
    switch (profile) {
      case "prod": {
        log.debug("Execution time of method is more than 150 ms ({} ms). METHOD INFO: {}",
            executionTime, getMethodInfo(proceedingJoinPoint));
        break;
      }
      case "dev": {
        log.warn("Execution time of method is more than 150 ms ({} ms). METHOD INFO: {}",
            executionTime, getMethodInfo(proceedingJoinPoint));
        break;
      }
      default:
    }
  }

  private String getMethodInfo(ProceedingJoinPoint proceedingJoinPoint) {
    return "signature - " + proceedingJoinPoint.getSignature() +
        ", args - " + Arrays.toString(proceedingJoinPoint.getArgs());
  }
}
