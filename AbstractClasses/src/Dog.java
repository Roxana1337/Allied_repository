public class Dog extends Animal{

    public Dog(String eat, int numberOfLegs, String sound) {
        super(eat, numberOfLegs, sound);
    }

    @Override
    public String isCarnivore() {
        return "Absolutely";
    }

    @Override
    public String canBeHeldInside() {
        return "Inside and outside";
    }
}
