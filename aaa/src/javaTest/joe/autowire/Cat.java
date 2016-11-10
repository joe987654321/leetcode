package javaTest.joe.autowire;

import org.springframework.stereotype.Component;

/**
 * Created by joe321 on 2016/11/10.
 */
@Component
public class Cat implements Animal{

    @Override
    public void makeNoice() {
        System.out.println("meow meow");
    }
}
