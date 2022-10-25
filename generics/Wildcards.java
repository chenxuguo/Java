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
        // raw = new Holder();
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

        // Object r1 = exact1(raw); // Warnings
        //    Unchecked conversion from Holder to Holder<T>
        //     Unchecked method invocation:exact1(Holder<T>)
        //     is applied to (Holder)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);  // Must return
        Long r4 = exact1(bounded);

        // Long r5 = exact2(raw, lng);  // Warnings:
        //      Unchecked conversion from holder to Holder<Long>
        //      Unchecked method invocation: exact2(Holder<T>, T)
        //      is appiled to (Holder, Long)
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng);    // Error:
        //      exact2(Holder<T>, T) cannot be applied to
        //      (Holder<capture of ?>, Long)
        // Long r8 = exact2(bounded, lng);  // Error;
        //  exact2(Holder<T>, T) cannot be appied
        //  to (Holder<capture of ? extends Long>, Long)

        // Long r9 = wildSubtype(raw, lng); // Warnings:
        //      Unchecked conversion from Holder
        //      to Holder<? extends Long>
        //      Unchecked method invocation:
        //      wildSubtype(Holder<? extends T>, T) is
        //      applied to (Holder, Long)
        Long r10 = wildSubtype(qualified, lng);
        // Ok, but can only return Object:
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        // wildSupertype(raw, lng); // Warnings:
        //      Unchecked conversion from Holder
        //      to HOlder<? super T>
        //      Unchecked method invocation:
        //      wildSupertype(Holder<? super T>, T)
        //      is applied to (Holder, Long)
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng);   // Error:
        //  wildSupertype(Holder<? super T>, T) cannot be
        //  applied to (Holder<capture od ?>, Long)
        // wildSupertype(bounded, lng);     // Error:
        //  wildSupertype(Holder<? super T>, T) cannot be
        //   applied to (Holder<capture of ? extends Long> Long)
    }
} //:~
