import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    //Annotations task 1

    @Target(ElementType.METHOD)
    @interface MyFirstAnnotation {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface MySecondAnnotation {
        String value() default "This is my default value";
    }

    @Target(ElementType.FIELD)
    @interface MyThirdAnnotation {
        int value1();
        boolean value2();
        String value3() default "This is a default value";
    }