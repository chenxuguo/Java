package generics;
import java.util.*;
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());  // Error;
        // Incompatible types: found fruit, required Apple
    }
    static <T> void
    writewithwildcard(List<? super T> list, T item){
        list.add(item);
    }
    static void f2() {
        writewithwildcard(apples, new Apple());
        writewithwildcard(fruit,new Apple());
    }
    public static void main(String[] args) {
        f1();f2();
    }
}
