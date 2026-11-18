package tn.esprit.autoloc.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    /**
     * @AfterThrowing advice – intercepts any exception thrown by a service method.
     * Logs the method name, the exception type, and the error message.
     */
    @AfterThrowing(
            pointcut = "execution(* tn.esprit.autoloc.service.*.*(..))",
            throwing = "exception"
    )
    public void handleException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        String exceptionType = exception.getClass().getName();
        String errorMessage = exception.getMessage();

        logger.error("🔴 [EXCEPTION] Une exception a été levée dans la méthode : {}", methodName);
        logger.error("   Type de l'exception  : {}", exceptionType);
        logger.error("   Message d'erreur     : {}", errorMessage);
    }
}
