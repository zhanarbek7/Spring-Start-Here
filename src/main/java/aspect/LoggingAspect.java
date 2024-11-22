package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import service.CommentService;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Around("execution(* service.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint){
        logger.info("Method will execute");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            logger.log(Level.INFO, "Error publishing comment", e);
        }
        logger.info("Method executed");
    }
}
