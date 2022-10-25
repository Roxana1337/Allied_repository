public class Dog extends Animal {
    @Override
    public String isCarnivore(boolean v1) {
        return "Yes";
    }

    @Override
    public String canBeHeldInside() {
        return "Sometimes";
    }
}