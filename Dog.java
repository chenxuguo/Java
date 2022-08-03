
public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    public static void main(String[] args) {
        System.out.println((new Dog()).id());
        System.out.println((new Dog()).id());
        System.out.println((new Dog()).id());
    }
}
