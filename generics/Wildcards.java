package generics;

public class Wildcards {
    // Raw argument:
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg);    // Warning
        holder.set(new Wildcards());    // Same warning
        // T t = holder.get();
        // OK, but type information has been lost:
        Object obj = holder.get();
    }
    // Similar to rawArgs(), but errors instead of
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg);    // Error
        Object obj = holder.get();
    }
    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }
    static <T>
    T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.set(arg);
        T t = holder.get();
        return t;
    }
    static <T>
    void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        // T t = holder.get(); // Error:
        //  Incompitible types: found Object, required T
        // Ok, but type information has beeen lost:
        Object obj = holder.get();
    }
    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
    }
}
