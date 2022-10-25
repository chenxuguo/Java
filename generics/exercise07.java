package generics;

import arrays.CountingGenerator;
import static net.mindview.util.Print.*;

import java.util.Iterator;

public class exercise07 implements Iterable<Integer> {
    private Fibonacci gen;
    private int count = 0;
    exercise07(int count){
        this.count = count;
        gen = new Fibonacci();
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return gen.next();
            }
        };
    }
    public static void main(String[] args) {
        exercise07 ex = new exercise07(10);
        for(int i : ex)
            print(i);
    }
}
