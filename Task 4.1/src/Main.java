import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Employee> myList0fEmployees = new ArrayList<>();
        Employee employee1 = new Employee(1, "Developer", 5000, "1 year");
        Employee employee2 = new Employee(2, "Manager", 9000, "5 years");
        Employee employee3 = new Employee(3, "Janitor", 950, "2 years");
        Employee employee4 = new Employee(4, "Developer", 7000, "5 years");
        Employee employee5 = new Employee(5, "Developer", 7500, "3 years");
        Employee employee6 = new Employee(6, "Developer", 7500, "3 years");
        Employee employee7 = new Employee(7, "Assistant manager", 8500, "2 years");
        Employee employee8 = new Employee(8, "Assistant manager", 8400, "2.5 years");
        Employee employee9 = new Employee(9, "Manager", 11000, "10 years");
        Employee employee10 = new Employee(10, "Janitor", 900, "6 months");
        myList0fEmployees.add(employee1);
        myList0fEmployees.add(employee2);
        myList0fEmployees.add(employee3);
        myList0fEmployees.add(employee4);
        myList0fEmployees.add(employee5);
        myList0fEmployees.add(employee6);
        myList0fEmployees.add(employee7);
        myList0fEmployees.add(employee8);
        myList0fEmployees.add(employee9);
        myList0fEmployees.add(employee10);

        //TODO: subtask 1: filter method to filter object by salary > 1000;
        //TODO: subtask 2: peek method to prind the selected fields;
        //TODO: subtask 3: map the stream to another stream by adding position;
        //TODO: subtask 4: use method reference to print out the newly mapped stream;


            myList0fEmployees.stream().filter(employee -> employee.getSalary() > 1000)
                    .peek(employee -> System.out.println(employee.getSalary()))
                    .map(Employee::getPosition).forEach(System.out::println);



        //TODO: subtask 5: print the object with minimum salary

        Employee myMinim = myList0fEmployees.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(myMinim);

        //TODO: subtask 6: map with key = id and value = object

        Map<Integer, Employee> objectAndId = myList0fEmployees.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println(objectAndId);

        //TODO: Task 2 subtask 1: split method to split the numbers from the string\
        //TODO: distinct method to bring only unique values
        //TODO: sorted method to sort them in ascending order
        //TODO: peek method to print out the sorted unique values
        //TODO: mapToInt method to parse all numbers to int
        //TODO: sum method to sum all numbers


        String numbers = "1,3,2,2,5,4";

        System.out.println(Arrays.stream(numbers.split(",")).distinct().sorted()
                .peek(System.out::println).mapToInt(Integer::parseInt).sum());

    }

}