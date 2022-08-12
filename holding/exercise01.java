package holding;
import java.util.*;

class Gerbil{
    int n = 0;
    Gerbil(int n){
        this.n = n;
    }
    public String toString(){
        return "gerbil" + n;
    }
}

public class exercise01 {
    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<Gerbil>();
        for(int i = 0; i < 10; i++ )
            gerbils.add(new Gerbil(i));
        for(Gerbil gerbil : gerbils )
            System.out.println(gerbil);
    }
}
