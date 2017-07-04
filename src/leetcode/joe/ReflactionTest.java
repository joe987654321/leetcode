package leetcode.joe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflactionTest {

    public static void main(String[] args) throws Exception {
        String a = "abc";
        Object[] objs = new Object[2];
        a.charAt(0);
        testReflaction(a, "charAt");
    }

    public static void testReflaction(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName, int.class);
        Object o = method.invoke(obj, 2);
        System.out.println(((Character) o).charValue());
    }
}
