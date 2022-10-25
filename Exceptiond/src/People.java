public class People {
    String name;
    String surname;
    int age;

    public People(String firstName, String lastName, Integer ageOfPerson) {
        this.name = firstName;
        this.surname = lastName;
        this.age = ageOfPerson;
    }

    public int getAge() {
        return age;
    }
}
