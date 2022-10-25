public class Main {
    public static void main(String[] args) throws Exception {

        People person1 = new People("Andrei", "Podaru", 24);

        if (person1.getAge() < 0) {
            throw new InterruptedException("Invalid age");
        } if (person1.getAge() > 0 && person1.getAge() < 18) {
            throw new InterruptedException("This age is below our requirements");
        } System.out.println("This age is valid");



        try {
            People person2 = new People("Andreea", "Lupascu", 0);
            if (person2.getAge() < 0) {
                throw new NullPointerException("Invalid age");
            } if (person2.getAge() == 0) {
                throw new NullPointerException(("Age cannot be null"));
            } if (person2.getAge() > 0 && person2.getAge() < 18) {
                throw new NullPointerException("This age is below our requirements");
            }
             System.out.println("This age is valid");
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        }

        try {
            People person3 = new People("Lucian", "Lupu", 15);
            if (person3.getAge() < 0) {
                throw new Exception("Invalid age");
            } if (person3.getAge() > 0 && person3.getAge() < 18) {
                throw new Exception("This age is below our requirements");
            } System.out.println("This age is valid");
        } catch (Exception e1) {
            e1.printStackTrace();
            throw e1;
        }
    }
}