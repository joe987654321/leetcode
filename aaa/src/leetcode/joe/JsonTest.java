package leetcode.joe;


public class JsonTest {

    public static class B {
        String ccc = "helloworld";
        Integer ddd = new Integer(4);
    }

    public static class A {
        int aaa = 1111;
        B bbb = new B();
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.toString());
    }
}
