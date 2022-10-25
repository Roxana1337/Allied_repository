public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cat("only cat food", 4, "Meow!");
        Animal dog1 = new Dog("bones and meat", 4,"Ham-Ham!");
        System.out.println("Can the cat be held inside ? "
                + cat1.canBeHeldInside());
        System.out.println("Can the dog be held inside ? "
                + dog1.canBeHeldInside());
        System.out.println("Is a cat carnivore ? " + cat1.isCarnivore());
        System.out.println("Is a dog carnivore ? " + dog1.isCarnivore());
        Sturgeon sturgeon1 = new Sturgeon();
        System.out.println("Can a sturgeon live on land ? "
                + sturgeon1.doesItLiveOnLand());
        System.out.println("Can a cat live on land ? "
                + cat1.doesItLiveOnLand());

    }
}