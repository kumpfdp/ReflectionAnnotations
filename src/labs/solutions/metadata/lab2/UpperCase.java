package labs.solutions.metadata.lab2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Anil Pal
 *
 */
@Retention(value=RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UpperCase {
	int length() default -1;
}
