package tn.esprit.autoloc.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    private static final long SLOW_METHOD_THRESHOLD_MS = 1000L;

    /**
     * @Around advice – wraps every method in the service package.
     * Measures execution time, logs it in ms, and warns if it exceeds 1000 ms.
     */
    @Around("execution(* tn.esprit.autoloc.service.*.*(..))")
    public Object measurePerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().toShortString();

        long startTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;

        logger.info("⏱  [PERFORMANCE] Méthode '{}' exécutée en {} ms", methodName, executionTime);

        if (executionTime > SLOW_METHOD_THRESHOLD_MS) {
            logger.warn("⚠️  [PERFORMANCE] ATTENTION : la méthode '{}' a dépassé le seuil de {} ms (durée réelle : {} ms)",
                    methodName, SLOW_METHOD_THRESHOLD_MS, executionTime);
        }

        return result;
    }
}
