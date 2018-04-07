package labs.solutions.metadata.lab2;

import java.lang.reflect.Field;

/**
 * 
 * @author Anil Pal
 *
 */
public class LengthValidator {

	public static void main(String [] args) throws IllegalArgumentException, IllegalAccessException {
		
		LengthValidator lengthValidator = new LengthValidator();
		Car car = new Car();
		car.setModelName("MyModel");
		
		lengthValidator.processLengthValidation(car);
		
		System.out.println(car);
		
	}
	
	public void processLengthValidation(Object target) throws IllegalArgumentException, IllegalAccessException {
		Class clazz = target.getClass();
		
		Field [] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(field.isAnnotationPresent(Length.class)) {
				Length annotation = (Length)field.getAnnotation(Length.class);
				
				//Get the old value
				String oldValue = (String)field.get(target);
				
				int min = annotation.min();
				int max = annotation.max();
				
				if(oldValue.length() < min || oldValue.length() > max) {
					System.err.printf("Length Error: %s should be between %d and %d\n", oldValue, min, max);
				}
			}
		}
	}
}
