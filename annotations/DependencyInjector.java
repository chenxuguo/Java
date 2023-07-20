import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class DependencyInjector {
	private Map<Class<?>, Object> dependencyMap = new HashMap<Class<?>, Object>();

	public void register(Class<?> clazz, Object instance){
		dependencyMap.put(clazz, instance);
	}
    public void injectDependencies(Object target) throws IllegalAccessException {
        Class<?> clazz = target.getClass();	
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = dependencyMap.get(field.getType());
                if (dependency != null) {
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    field.set(target, dependency);
                    field.setAccessible(accessible);
                } else {
                    throw new IllegalStateException("No registered dependency for " + field.getType());
                }
            }
        }
    }
}

