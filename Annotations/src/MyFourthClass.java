//class for Reflection Task 4

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyFourthClass {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object myObject = new MyFourthClass();
        Class myClass = myObject.getClass();
        Method myMethod = myClass.getMethod("myFirstMethod", String.class);
        myMethod.invoke(myObject, "Another string");
    }

    public void myFirstMethod(String name) {
        System.out.println(name);
    }
}
