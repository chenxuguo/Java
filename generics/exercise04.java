package generics;
import java.util.*;
import typeinfo.pets.*;

interface Selector {
    boolean end();
    Object current();
    void next();
}
public class exercise04<T> {
    private ArrayList<T> items;
    private int next = 0;

    public exercise04(int size) {
        items = new ArrayList<T>(size);
    }

    public void add(T x) {
        items.add(x);
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.size();
        }

        public Object current() {
            return items.get(i);
        }

        public void next() {
            if (i < items.size()) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        exercise04<Individual> sequence = new exercise04<Individual>(10);
        for (int i = 0; i < 10; i++)
            sequence.add(new Individual());
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
