package aspect;

import models.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import service.CommentService;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Around("execution(* service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Object returnedByMethod = null;
        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");
        try {
            Comment comment = new Comment();
            comment.setText("Some other text!");
            Object[] newArguments = new Object[]{comment};
            returnedByMethod = joinPoint.proceed(newArguments);
        }
        catch (Throwable e) {
            logger.log(Level.INFO, "Error publishing comment", e);
        }
        logger.info("Method executed and returned " + returnedByMethod);
        return  "FAILED";
    }
}
