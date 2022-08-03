public class Individual implements Comparable<Individual>{
    private static int counter = 0;
    private final int id = counter++;
    String name;
    Individual(String myname){
        name = myname;
    }
    Individual(){};
    public int id(){
        return id;
    }
    public String toString(){
        return this.getClass().getName();
    }
    public int compareTo(Individual ind){
       return this.id() - ind.id();
    }
    public static void main(String[] args){
        System.out.println((new Individual()).id());
        System.out.println((new Individual()).id());
        System.out.println((new Individual()).id());
    }
}
