import java.util.*;

public class FindPrime{
    public static <T>
    int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p){ return 0;};
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        findFirst(list,0, list.size(), new UnaryPredicate<Integer>());
    }
}

interface UnaryPredicate<T>{
    public boolean test(T obj);
}

//class RelativelyPrimepredicate implements UnaryPre