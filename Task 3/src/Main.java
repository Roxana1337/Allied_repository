import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Students> studentsList = new LinkedList<>();
            Students student1 = new Students("Maria", "Ionescu");
            Students student2 = new Students("Maria", "Ionescu");
            Students student3 = new Students("Andrei", "Ilascu");
            Students student4 = new Students("Lavinia", "Oracol");
            Students student5 = new Students("Marius", "Obreja");
            Students student6 = new Students("Lavinia", "Oracol");
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        System.out.println("Are the first two students the same ? " + student2.equals(student1));
        if(student2.hashCode() == student1.hashCode()) {
            System.out.println("The first two students have identical hashcode");
        } else {
            System.out.println("The first two students have different hashcode");
        }

        System.out.println("Are the first and third students the same ? " + student1.equals(student3));
        if(student1.hashCode() == student3.hashCode()) {
            System.out.println("The first and the third students have identical hashcode");
        } else {
            System.out.println("The first and the third students have different hashcode");
        }

        System.out.println(studentsList.contains(student3));

        HashMap<Students, String> studentHashMap= new HashMap<>();
        studentHashMap.put(student4, "Good grades");
        studentHashMap.put(student5, "Bad grades");
        studentHashMap.put(student6, "Good grades");
        System.out.println(studentHashMap);
        System.out.println(studentHashMap.get(student6).equals(studentHashMap.get(student4)));
        }
}