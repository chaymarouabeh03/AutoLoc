package tn.esprit.autoloc.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * @Before advice – runs before every method in the service layer.
     * Logs the method name and all argument values.
     */
    @Before("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info(">>> [BEFORE] Appel de la méthode : {}", methodName);
        logger.info("    Paramètres : {}", Arrays.toString(args));
    }

    /**
     * @After advice – runs after every method in the service layer.
     * Logs the method name that just finished executing.
     */
    @After("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        logger.info("<<< [AFTER]  Fin d'exécution de la méthode : {}", methodName);
    }
}
