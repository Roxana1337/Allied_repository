import java.util.Objects;

public class Students {
    public String name;
    public String surname;

    Students(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return Objects.equals(name, students.name) && Objects.equals(surname, students.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
