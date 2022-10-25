public class People {
    String name;
    String surname;
    int age;

    public People(String firstName, String lastName, Integer ageOfPerson) {
        this.name = firstName;
        this.surname = lastName;
        this.age = ageOfPerson;

        if (firstName.equals("") || firstName.equals(null)) {
            throw new ArithmeticException("Invalid first name");
        }
        if (lastName.equals("") || lastName.equals(null)) {
            throw new ArithmeticException("Invalid last name");
        }
        if (age < 0) {
            throw new NullPointerException("Invalid age");
        }
    }
}