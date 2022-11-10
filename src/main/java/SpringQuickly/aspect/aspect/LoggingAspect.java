package SpringQuickly.aspect.aspect;

import SpringQuickly.aspect.service.CommentService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 *  logging aspect
 *  http://mng.bz/4K9g
 */
@Aspect
@Order(10001)
@Component
public class LoggingAspect {
    Logger logger = Logger.getLogger(CommentService.class.getName());

    @Around("execution(* SpringQuickly.aspect.service.*.publishComment(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Logging aspect: Before execution " + joinPoint.getSignature().getName() + "() method...");
        logger.info("Args: " + Arrays.asList(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        logger.info("Logging aspect: Method " + joinPoint.getSignature().getName() + "() return " + result);
        return result;
    }

    @Around("@annotation(SpringQuickly.aspect.customAnnotation.ToLog)")
    public Object toLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Logging aspect: Before execution " + joinPoint.getSignature().getName() + "() method...");
        logger.info("Args: " + Arrays.asList(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        logger.info("Logging aspect: Method " + joinPoint.getSignature().getName() + "() return " + result);
        return result;
    }
}
