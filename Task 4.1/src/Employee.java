public class Employee {
    private int id;

    private String position;
    private int salary;
    private String experience;

    public Employee(int id, String position, int salary, String experience) {
        this.id = id;
        this.position = position;
        this.salary = salary;
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getExperience() {
        return experience;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", experience='" + experience + '\'' +
                '}';
    }
}
