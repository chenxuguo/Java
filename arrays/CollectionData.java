package arrays;

import generics.Generator;
import java.util.*;
import java.util.Collection;

public class CollectionData<T> extends ArrayList<T>{
    public CollectionData(Generator<T> gen, int quantity) {
        for( int i = 0; i < quantity; i++)
            add(gen.next());
    }
    // A generic conveniece mrthod:
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}
