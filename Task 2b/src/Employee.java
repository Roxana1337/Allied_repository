public class Employee {
    private String name;
    private int yearsOfExperience;
    public static int count = 0;

    Employee(String name, int yearsOfExperience) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        count++;
    }

}

