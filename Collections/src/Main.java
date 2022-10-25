import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Collections task 1
        List<String> myAnimalsList = new ArrayList<>();
        myAnimalsList.add("dog");
        myAnimalsList.add("cat");
        myAnimalsList.add("fish");
        myAnimalsList.add("bunny");
        myAnimalsList.add("snake");
        myAnimalsList.add("chinchilla");
        for (String myString : myAnimalsList) {
            System.out.println(myString);
        }

        //Collections task 2
        Map<String, List<Integer>> myMapOfStringIntegers = new HashMap<>();
        myMapOfStringIntegers.put("Office thermostat", Arrays.asList(20,15,40));
        myMapOfStringIntegers.put("Home thermostat", Arrays.asList(21,23,24));
        System.out.println("The temperatures registered are: " +
                myMapOfStringIntegers);

        //Collections task 3
        Set<String> myStringSet = new HashSet<>();
        myStringSet.add("stringSet1");
        myStringSet.add("stringSet2");
        myStringSet.add("stringSet3");
        myStringSet.add("stringSet4");
        myStringSet.add("stringSet5");
        System.out.println("My third element is: " + myStringSet);
        //in order to get the third element from a set
        //we need to convert the set into an array
        //otherwise the third element will not the same as the third one added to the Set

        //Collections task 4
        List<String> myListOfStrings = new ArrayList<>();
        myListOfStrings.add("A");
        myListOfStrings.add("C");
        myListOfStrings.add("B");
        myListOfStrings.add("E");
        myListOfStrings.add("D");
        System.out.println("My list before sorting is: " + myListOfStrings);
        Collections.sort(myListOfStrings);
        System.out.println("My list after sorting is: " + myListOfStrings);

        //Collections task 5
        String myString[] = new String[] {"string1", "string2", "string3"};
        List<String> listOfMyString = Arrays.asList(myString);
        System.out.println("My list of strings is: " + listOfMyString);
        Integer myInteger[] = new Integer[] {1, 2, 3, 4};
        List<Integer> listOfIntegers = Arrays.asList(myInteger);
        System.out.println("My list of integers is: " + listOfIntegers);
        Double myDouble[] = new Double[] {1.0, 2.0, 3.0, 4.0, 5.0};
        List<Double> listOfDoubles = Arrays.asList(myDouble);
        System.out.println("My list of doubles is: " + listOfDoubles);

        //Collections task 6
        List<Double> myListOfDouble = new ArrayList<>();
        myListOfDouble.add(12.5);
        myListOfDouble.add(4.15);
        myListOfDouble.add(10D);
        myListOfDouble.add(-12D);
        double[] myListOfDoubleToArray = myListOfDouble.stream()
                .mapToDouble(Double::doubleValue).toArray();
        for(Double myDoubleForEach : myListOfDoubleToArray) {
            System.out.println(myDoubleForEach);
        }

        //Collections task 7
        Map<String, Integer> myStringIntegerMap= new HashMap<>();
        myStringIntegerMap.put("First element", 1);
        myStringIntegerMap.put("Second element", 2);
        myStringIntegerMap.put("Third element", 3);
        myStringIntegerMap.put("Fourth element", 4);
        myStringIntegerMap.put("Fifth element", 5);
        for(Map.Entry<String, Integer> sorting : myStringIntegerMap.entrySet()) {
            System.out.println(sorting.getKey() + " : " + sorting.getValue());
        }

        //Collections task 8
        Map<String, Integer> mapMethodsExample = new HashMap<>();
        mapMethodsExample.put("Person 1", 1);
        mapMethodsExample.put("Person 2", 2);
        mapMethodsExample.put("Person 3", 3);
        System.out.println("Is Person 4 available ? " + mapMethodsExample.containsKey("Person 4"));
        System.out.println("Is Person 3 available ? " + mapMethodsExample.containsKey("Person 3"));
        System.out.println("Is the number 4 present ? " + mapMethodsExample.containsValue(4));
        System.out.println("Is the number 3 present ? " + mapMethodsExample.containsValue(3));






    }
}