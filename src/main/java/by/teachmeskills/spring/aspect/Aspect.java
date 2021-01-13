package by.teachmeskills.spring.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect

public class Aspect {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("execution(* by.teachmeskills.spring.operations.IOperations.textOperation(..))")
    public void allOperationsMethods() {

    }

    @Before("allOperationsMethods()")
    public void beforeOperation() {
        logger.info("Operation started");
    }

    @After("allOperationsMethods()")
    public void afterOperation() {
        logger.info("Operation ended");

    }

    @Around("allOperationsMethods()")
    public void timeChecker(ProceedingJoinPoint joinPoint) {

        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("time of operation is: " + (end - start));
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
        }
    }

    @AfterThrowing("allOperationsMethods()")
    public void exceptionInformer() {
        logger.info("Cannot check the text");
    }
}



