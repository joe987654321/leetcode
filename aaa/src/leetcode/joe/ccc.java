package leetcode.joe;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigList;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;

public class ccc {

    private static class ID {
        int id;
        String value;
        ID (int i, String v) {
            id = i;
            value = v;
        }
    }

    private static enum Nested {
        AAA,
        BBB,
        NULL,
    }


    private static class Data {
        private int id;
        private String desc;
        private Nested nested;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getDesc() {
            return desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
        public Nested getNested() {
            return nested;
        }
        public void setNested(Nested nested) {
            this.nested = nested;
        }


    }

    public static class BigData<E extends Enum<E>> {

        E smallData;

        BigData(E input) {
            smallData = input;
        }

        public void printTemplateClassName() {
            if (smallData.getClass() == Nested.class) {
                System.out.println("They are the same!!");
            }

            System.out.println(smallData.getClass().toString());
        }
    }

    /**
     * @param args
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {

/*
        Data data = new Data();
        data.setId(1);
        data.setDesc("description");
        data.setNested(Nested.AAA);
    //    data.nested.value = "in hello world";

        data.getClass().getFields();
        for(PropertyDescriptor propertyDescriptor :
            Introspector.getBeanInfo(data.getClass(), Object.class).getPropertyDescriptors()){

            // propertyEditor.getReadMethod() exposes the getter
            // btw, this may be null if you have a write-only property
            System.out.println(propertyDescriptor.getReadMethod());

            Method m = propertyDescriptor.getReadMethod();
            Object obj = m.invoke(data,  new Object[] {} );
            System.out.println(obj.toString());
        }
*/
        /*
        for (Field f: data.getClass().getFields()) {
            f.setAccessible(true);
       //     System.out.println(f.getName() + "AA");
            if (f.get(data) == null) {
                System.out.println(f.getName() + " is null");
            }
            System.out.println(f.get(data));
        }
*/
/*
        Nested input = Nested.AAA;
        BigData<Nested> bigdata = new BigData<Nested>(input);
        bigdata.printTemplateClassName();
        */
/*
        try {
            JSONObject responseData = new JSONObject(
                    "{\"aaa\" : FALSE}"
                );
            boolean x = responseData.getBoolean("aaa");
            System.out.println(x);
        } catch (JSONException e) {
            // TODO 自動產生的 catch 區塊
            e.printStackTrace();
        }
*/
/*
        Config c = ConfigFactory.parseString("title = [ {name=t1, n1=123, n2=999} , {name=t2, n1=456, n2=888}, {name=s1}, {name=s2} ]");

        for (Config c2: c.getConfigList("title")) {
            if (c2.getString("name").startsWith("t")) {
                System.out.println(c2.getString("n1"));
            }
        }
*/
        /*
        for (Config c2: c.getConfigList("title")) {
            if (c2.getString("name").startsWith("t")) {
                System.out.println(c2.getString("n1"));
            }
        }
        */

        Config c = ConfigFactory.parseString("title { t1 { n1=123, n2=999} ,  t2 { n1=456, n2=888}, s1 {}, s2 {} }");

        ConfigObject c2 = c.getObject("title");
        for (String a : c2.keySet()){
            System.out.println(a);
        }

        System.out.println(c2);
        System.out.println(c2.toConfig());
        System.out.println(c2.toConfig().root());

    }

}
