public class Cat extends Animal {


    @Override
    public String isCarnivore(boolean v1) {
        return "Not necessarily";
    }

    @Override
    public String canBeHeldInside() {
        return "Yes";
    }
}