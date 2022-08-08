package generics;
import static generics.New.*;
import typeinfo.pets.*;
import static net.mindview.util.Print.*;
import java.util.*;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        petPeople.put(new Person("Dawn"),
            Arrays.asList(new Cymric("Molly"),new Mutt("Spot")));
        petPeople.put(new Person("Kate"),
            Arrays.asList(new Cat("Shackleton"),
                 new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"),
            Arrays.asList(
                 new Pug("Louie aka Louis Snorkelstein Dupree"),
                 new Cat("Stanford aka Stinky el Negro"),
                 new Cat("Pinkola")));
        petPeople.put(new Person("Luke"),
            Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"),
            Arrays.asList(new Rat("Freckly")));
        print("People: " + petPeople.keySet());
        print("Pets : " + petPeople.values());
        for(Person person : petPeople.keySet()){
            print("person has pets :");
            for(Pet pet : petPeople.get(person))
                print("    " + pet);
        }

    }
}
