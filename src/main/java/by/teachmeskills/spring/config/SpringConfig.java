package by.teachmeskills.spring.config;

import by.teachmeskills.spring.TextReader;

import by.teachmeskills.spring.aspect.Aspect;
import by.teachmeskills.spring.operations.uppercase.UpperCaseOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.teachmeskills.spring")
@EnableAspectJAutoProxy
public class SpringConfig {


}
