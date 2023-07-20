//package annoatation.database;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
	int value() default 0;
	String name() default "";
	Constraints constraints() default @Constraints;
} ///:~
