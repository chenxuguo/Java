package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static net.mindview.util.Print.*;

public class DebugInvocationHandler implements InvocationHandler{
    /*
    dd
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        print("before method: " + method.getName());
        Object result = method.invoke(target, args);
        print("after method: " + method.getName() );
        return result;
    }
}


