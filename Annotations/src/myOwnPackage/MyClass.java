//class for Reflection task 1;

package myOwnPackage;

public class MyClass {

    public static void main(String[] args) {

        Object myObject = new MyClass();
        String shortName = myObject.getClass().getSimpleName();
        System.out.println("The short name of the class is: " + shortName);
        String fullName = myObject.getClass().getName();
        System.out.println("The full name of the class is: " + fullName);

    }
}
