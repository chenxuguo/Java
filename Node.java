class Node<T> implements Comparable<T> {
    public int compareTo(T obj) { /* ... */ return 0;}
    // ...
    public static void main(String[] args){
        Node<String> node = new Node<>();
        Comparable<String>  com = node;
    }
}

