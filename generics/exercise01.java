package generics;
import typeinfo.pets.*;
import static net.mindview.util.Print.*;

public class exercise01 {
    public static void main(String[] args) {
                Holder3<Pet> h31 = new Holder3<Pet>(new Mouse());
                print(h31.get());
    }
}
