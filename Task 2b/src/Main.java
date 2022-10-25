import java.util.*;

public class Main {
    public static void main(String[] args) {
        //TODO create a class with one static class field = count of created objects
        //TODO new object => counter++
        //TODO in main method, 2+ objects => print counter
        //TODO compare fields of objects
        ArrayList<Employee> employeesArrayList = new ArrayList<>();
        Set<Employee> set = new HashSet<Employee>(employeesArrayList);
        Employee firstEmployee = new Employee("Popescu Ion", 0);
        employeesArrayList.add(firstEmployee);
        Employee secondEmployee = new Employee("Ionescu Gigel", 4);
        employeesArrayList.add(secondEmployee);
        Employee thirdEmployee = new Employee("Stanciu Elena", 2);
        employeesArrayList.add(thirdEmployee);
        Employee fourthEmployee = new Employee("Stanciu Elena", 2);
        employeesArrayList.add(fourthEmployee);
        System.out.println("There are " + Employee.count + " employees in the company");
        if(set.size() < employeesArrayList.size()) {
            System.out.println("At least one employee is twice in the list");
        }


    }
}