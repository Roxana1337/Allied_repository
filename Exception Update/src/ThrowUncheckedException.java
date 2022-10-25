class ThrowUncheckedException extends Throwable {
    public static void main(String[] args) {
        int [] myListOfNames = {4, 5, 15, 16, 23, 42};
        try {
//            System.out.println(ThrowUncheckedException.appLogic
//                    (myListOfNames, 6, "5.7"));
//            System.out.println(ThrowUncheckedException.appLogic
//                    (myListOfNames, 5, "Myname"));
            System.out.println(ThrowUncheckedException.appLogic
                    (myListOfNames,5,"57"));
        } catch (ArrayIndexOutOfBoundsException myUncheckedException){
            System.out.println("Please insert a correct index");
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Please insert a valid number");
        }
    }

    private static int appLogic(int[] myListOfNumbers, int index, String number)
            throws ArrayIndexOutOfBoundsException, NumberFormatException {
        return myListOfNumbers[index] - Integer.parseInt(number);
    }
}