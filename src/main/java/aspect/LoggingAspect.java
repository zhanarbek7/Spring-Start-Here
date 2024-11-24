package aspect;

import models.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import service.CommentService;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue) {
        logger.info("Method executed and returned " + returnedValue);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
