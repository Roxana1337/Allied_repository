public class ClassForMyUncheckedException {

    public ClassForMyUncheckedException(String name, String surname, int yearsOfExperience) {
        if (name.equals("") || name.equals(null)) {
            throw new ArithmeticException("Invalid first name");
        }
        if (surname.equals("") || surname.equals(null)) {
            throw new ArithmeticException("Invalid last name");
        }
        if (yearsOfExperience < 0) {
            throw new NullPointerException("Invalid age");
        }
    }
}
