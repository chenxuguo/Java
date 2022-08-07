package generics;
import typeinfo.pets.*;
import static net.mindview.util.Print.*;

public class exercise06 {
    public static void main(String[] args){
        RandomList<Pet> pets = new RandomList<Pet>();
        PetCreator a = new LiteralPetCreator();
        for(int i = 0; i < 10; i++){
            pets.add(a.randomPet());
        }
        for (int i = 0; i < 10; i++ ) {
            print(pets.select());
        }
    }
}
