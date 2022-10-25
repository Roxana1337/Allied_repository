//class for Reflection Task 3

import java.lang.reflect.Field;

public class MyThirdClass {
    public static void main(String[] args) {
        Field[] myFields = MyThirdClass.class.getDeclaredFields();
        for(Field field : myFields) {
            System.out.println(field.getName());
        }

    }
    public static String myFirstField = "My first field";

    public static String mySecondField = "My second field";

    public int myThirdField = 4;

    public Double myFourthField = 2.0;
}
