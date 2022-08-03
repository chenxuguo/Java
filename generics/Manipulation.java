package generics;

public class Manipulator<T extends HasF> {
    private T obj;
    public Manipulator(T x){ obj = x; }
    // Error: can't find symbol: method f();
    public void manipulate() { obj.f(); }
}

public class Manipulat {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator =
                new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
}
