package generics;
import java.util.*;

public class MultipleInterfaceVariants {
    public static void main(String[] args){
        new Employee1();
        List<String> ls = new ArrayList<String>();
        List<Integer> li = new ArrayList<Integer>();
        ls.add("asd");
        li.add(1);
    }
}

interface Payable<T> {}

class Employee1 implements Payable {}
class Hourly extends Employee1
    implements Payable {}