package generics;
import com.sun.istack.internal.NotNull;

import java.util.*;

public class Ex29 {
    void func(Holder<List<?>> h){
        List<?> list = h.get();
        System.out.println(list.get(0));
    }
    void func1(List<Holder<?>> l){
        Holder<?> h = l.get(0);
        System.out.println(h.get());
    }
    public static void main(String[] args){
        List<Integer> a = Arrays.asList(1,2,3,4);
        Holder<List<?>> h = new Holder<>();
        h.set(a);
        new Ex29().func(h);
        Holder<Integer> oh = new Holder<Integer>();
        oh.set(1);
        Holder<?> hh = oh;
        List<Holder<?>> ol = new ArrayList<>();
        ol.add(oh);
        new Ex29().func1(ol);
    }
}
