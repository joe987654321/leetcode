package leetcode.joe;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.AbstractModule;;

public class InjectTest {

    public static interface BBB {
        public void printHello();
    }

    public static class BBBImpl implements BBB {
        @Override
        public void printHello() {
            System.out.println("B hello");
        }

    }

    public static class CCC {
        public void printHello() {
            System.out.println("C hello");
        }
    }

    public static class AAA {
        @Inject private BBB bbb;
        @Inject private CCC ccc;

        public void useBPrint() {
            bbb.printHello();
        }

        public void useCPrint() {
            ccc.printHello();
        }
    }

    public static class Moduleee extends AbstractModule {
        @Override
        protected void configure() {
            bind(BBB.class).to(BBBImpl.class);
        }
    }

    public static void main(String[] args) {
        AAA aaa = Guice.createInjector(new Moduleee()).getInstance(AAA.class);
        aaa.useBPrint();
        aaa.useCPrint();
    }
}
