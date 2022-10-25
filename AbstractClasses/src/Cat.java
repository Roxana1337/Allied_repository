public class Cat extends Animal{

    public Cat(String eat, int numberOfLegs, String sound) {
        super(eat, numberOfLegs, sound);
    }

    @Override
    public String isCarnivore() {
        return "not necessarily";
    }

    @Override
    public String canBeHeldInside() {
        return "Yes";
    }
}
