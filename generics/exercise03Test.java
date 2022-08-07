package generics;
import static net.mindview.util.Print.*;

import arrays.CountingGenerator;

public class exercise03Test {
    public static void main(String[] args) {
        exercise03<Integer, Float, Double, String, Character, Boolean>
                sixTuple = new exercise03<Integer, Float, Double, String,
                Character, Boolean>(1, (float)2.0,
                (double)3.0, "4", '5',Boolean.FALSE);
        print(sixTuple);
    }
}
