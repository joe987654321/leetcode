package javaTest.joe.autowire;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;


@Component
/**
 * Created by joe321 on 2016/11/10.
 */
public class Zoo {
    @Inject
    private Animal dog;

    @Resource(name="cat")
    private Animal animal2;

    @Qualifier("pickchu")
    @Autowired
    private Animal animal3;

    @Inject
    private List<Animal> animals;

    public void makeNoice() {
        dog.makeNoice();
        animal2.makeNoice();
        animal3.makeNoice();
    }

    public void makeAllNoice() {
        for (Animal a: animals) {
            a.makeNoice();
        }
    }
}
