//class for Reflection task 2;

import java.lang.reflect.Method;

public class MySecondClass {
    public static void main(String[] args) {

        Method[] myMethods = MySecondClass.class.getDeclaredMethods();
        for(Method method : myMethods) {
            System.out.println(method.getName());
        }
    }

    public static String myFirstMethod() {
        return "myFirstMethod";
    }

    public static String mySecondMethod() {
        return "mySecondMethod";
    }

    public int myThirdMethod() {
        return 1;
    }

    public Double myFourthMethod() {
        return 2.0D;
    }

}
