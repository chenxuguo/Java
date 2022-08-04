package generics;

public class SimplerHolder {
    private Object obj;
    public void set(Object obj) { this.obj = obj; }
    public Object get() { return obj; }
    public static void main(String[] args) {
        SimplerHolder holder = new SimplerHolder();
        holder.set("Item");
        String s = (String)holder.get();
    }
}
