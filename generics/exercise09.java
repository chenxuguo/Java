package generics;
import static net.mindview.util.Print.*;

public class exercise09 {
    public <A,B,C> void f(A a, B b, C c){
        print(a.getClass().getName());
        print(b.getClass().getName());
        print(b.getClass().getName());
        print();
    }
    public static void main(String[] args) {
        exercise09 ex = new exercise09();
        ex.f(1, "edfewf",'c');
    }

}
