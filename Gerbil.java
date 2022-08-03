import java.util.*;

public class Gerbil {
    private int gerBilnumber;
    Gerbil(int n){
        gerBilnumber = n;
    }
    public void hop(){
        System.out.println("Gerbil Numbr : is hopping" + gerBilnumber);
    }
    public static void main(String[] args){
        ArrayList<Gerbil> gerbilList = new ArrayList<Gerbil>();
        for(int i = 0; i < 10; i++){
            gerbilList.add(new Gerbil(i));
        }
        for(Gerbil gerbil : gerbilList){
            gerbil.hop();
        }
    }
}
