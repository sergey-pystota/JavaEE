package by.teachmeskills.spring;

import by.teachmeskills.spring.config.SpringConfig;
import by.teachmeskills.spring.operations.IOperations;
import by.teachmeskills.spring.operations.uppercase.UpperCaseOperation;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        final IOperations upper = configApplicationContext.getBean("upperCaseOperation", IOperations.class);
        final IOperations numbers = configApplicationContext.getBean("wordsNumberOperation", IOperations.class);
        numbers.textOperation();
        upper.textOperation();


    }
}
