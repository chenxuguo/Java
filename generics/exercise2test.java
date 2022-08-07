package generics;
import static net.mindview.util.Print.*;

public class exercise2test {
    public static void main(String[] args) {
        exercise02<Integer> ex02 = new exercise02<Integer>(1,2,3);
        print(ex02.getItem1());
        print(ex02.getItem2());
        print(ex02.getItem3());
    }
}
