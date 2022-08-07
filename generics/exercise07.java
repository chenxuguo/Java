package generics;

import arrays.CountingGenerator;
import static net.mindview.util.Print.*;

import java.util.Iterator;

public class exercise07 implements Iterable {
    private int count = 10;
    private Fibonacci fib = new Fibonacci();
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return fib.next();
            }
        };
    }
    public static void main(String[] args) {
        exercise07 ex = new exercise07();
        Iterator<Integer> it = ex.iterator();
        while(it.hasNext())
            print(it.next());
    }
}
