public class Main {
    public static void main(String[] args) {
        String ten = "10";
        String twoAndAHalf = "2.5";

        //TODO get int value from string "ten"
        int integerOfStringTen = Integer.parseInt(ten);
        System.out.println("The int value from string ten is: " + integerOfStringTen);
        //TODO get double value from string "twoAndAHalf"
        double doubleOfStringTwoAndAHalf = Double.parseDouble(twoAndAHalf);
        System.out.println("The double value from string twoAndAHalf is: "
                + doubleOfStringTwoAndAHalf);
        //TODO create a string from int value
        String stringIntten = String.valueOf(10);
        System.out.println("The string from the number 10 is: "
                + stringIntten);
        //TODO create a string from double value
        String stringDoubleTwoAndAHalf = String.valueOf(2.5);
        System.out.println("The string from the number 2.5 is: "
                + stringDoubleTwoAndAHalf);
    }
}