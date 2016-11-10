package javaTest.joe.autowire;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by joe321 on 2016/11/10.
 */
public class MainTestRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
       // ac.register(Zoo.class);

//        try {
//            Animal animal = ac.getBean(Animal.class);
//            animal.makeNoice();
//        } catch (BeansException e) {
//            e.printStackTrace();
//        }

        try {
            Zoo zoo = ac.getBean(Zoo.class);
            zoo.makeNoice();

            System.out.println("----------------------");
            zoo.makeAllNoice();
        } catch (BeansException e) {
            e.printStackTrace();
        }

        //Zoo zoo = new Zoo();
        //zoo.animal.makeNoice();
    }
}
