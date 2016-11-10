package javaTest.joe.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


/**
 * Created by joe321 on 2016/11/10.
 */
@ComponentScan("javaTest.joe.autowire")
@Configuration
public class BeanConfig {

//    @Bean
//    public Animal getDog() {
//        return new Dog();
//    }

//    @Bean
//    public Animal getCat() {
//        return new Cat();
//    }
}
