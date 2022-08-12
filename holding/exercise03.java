package holding;
import java.util.*;

interface Selector {
    boolean end ();
    void next();
    Object current();
}
public class exercise03 {
    List items = new ArrayList();
    void add(Object obj){
        items.add(obj);
    }
    class exercise03Selector implements Selector {
        int next = 0;
        public boolean end() { return next == items.size(); }
        public void next() { next++; }
        public Object current() { return items.get(next); }
    }
    public Selector selector() {
        return new exercise03Selector();
    }
    public static void main(String[] args){
        exercise03 ex = new exercise03();
       for(int i = 0; i < 10; i++)
           ex.add(i);
       Selector it = ex.selector();
       while(!it.end()) {
           System.out.println(it.current());
           it.next();
       }
    }
}
