package javaTest.joe.autowire;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Qualifier;


/**
 * Created by joe321 on 2016/11/10.
 */
@Qualifier("pickchu")
@Component
public class Pickchu implements Animal{

    @Override
    public void makeNoice() {
        System.out.println("pickchu");
    }
}
