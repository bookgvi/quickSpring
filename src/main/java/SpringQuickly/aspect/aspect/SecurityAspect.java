package SpringQuickly.aspect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(10001)
@Component
public class SecurityAspect {
    Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(SpringQuickly.aspect.customAnnotation.ToLog)")
    public Object securityAspectToLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security aspect: before method " + joinPoint.getSignature().getName() + "()");
        Object res = joinPoint.proceed();
        logger.info("Security aspect: after method " + joinPoint.getSignature().getName() + "()");
        return res;
    }
}
