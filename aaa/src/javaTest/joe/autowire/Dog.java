package javaTest.joe.autowire;

import org.springframework.stereotype.Component;

import javax.inject.Qualifier;

/**
 * Created by joe321 on 2016/11/10.
 */
@Component
public class Dog implements Animal{
    @Override
    public void makeNoice() {
        System.out.println("bow bow");
    }

}
