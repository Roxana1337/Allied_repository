public class Main {
    public static void main(String[] args) {
        Animal a1 = AdditionalFunction.myAdditionalFunction(true);
        Animal a2 = AdditionalFunction.myAdditionalFunction(false);
        System.out.println(a1);
        System.out.println(a2);
    }
}