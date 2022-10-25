public abstract class Animal {
    public String eat;
    public int numberOfLegs;
    public String sound;

    public Animal(String eat, int numberOfLegs, String sound) {
        this.eat = eat;
        this.numberOfLegs = numberOfLegs;
        this.sound = sound;
    }

    public abstract String isCarnivore();
    public abstract String canBeHeldInside();

    public String doesItLiveOnLand() {
        return "Yes";
    }
}
