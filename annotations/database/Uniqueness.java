//packkage annotation.database;

public @interface Uniqueness {
	Constraints constraints() default @Constraints(unique=true);
}

