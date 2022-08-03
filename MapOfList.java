import java.util.*;


public class MapOfList {
    static void print(Object str){
        System.out.println(str);
    }
    public static Map<Person, List<? extends Pet>>
        petPeople = new HashMap<Person, List<? extends Pet>>();
    static {
        petPeople.put(new Person("Dawn"),
                Arrays.asList(new Cymric("Molly"),new Mutt("Spot")));
        petPeople.put(new Person("kate"),
                Arrays.asList(new Cat("Shackleton"),
                        new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("marilyn"),
                Arrays.asList(
                        new Pug("Louie aka Louis Snorkeistein Dupree"),
                        new Cat("Stanford aka Stinky el Negro"),
                        new Cat("Pinkola") ));
        petPeople.put(new Person("Luke"),
                Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"),
                Arrays.asList(new Rat("Freckly")));
    }
    public static void main(String[] args) {
        print("people:" + petPeople.keySet());
        print("Pets:" + petPeople.values());
        for (Person person : petPeople.keySet()) {
            print(person + " has: ");
            for(Pet pet : petPeople.get(person))
                print("     " + pet);
        }

    }
}
