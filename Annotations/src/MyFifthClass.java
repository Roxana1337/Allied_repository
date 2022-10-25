//Class for Reflection Task 5

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyFifthClass {

    @MySecondAnnotation(value = "Whatever string")
    public String myStringUsedForAnnotation = "This is a string";

    public void myMethod() {
        System.out.println(myStringUsedForAnnotation);
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyFifthClass myObject = new MyFifthClass();
        Field myField = myObject.getClass().getDeclaredField("myStringUsedForAnnotation");
        Method myMethod = myObject.getClass().getDeclaredMethod("myMethod");
        myObject.myStringUsedForAnnotation = myField.getAnnotation(MySecondAnnotation.class).value();
        myMethod.invoke(myObject);
    }
}
