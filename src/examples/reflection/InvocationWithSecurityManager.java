package examples.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

import examples.reflection.sneaky.SneakyReflector;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class InvocationWithSecurityManager {

	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());

		String className = "examples.reflection.DummyClass";
		System.out.println("Relecting HERE ******");
		reflectHere(className);

		/*
		System.out.println("Relecting THERE ******");
		reflectThere(className);

		System.out.println("Relecting THERE With increased Access ******");
		reflectThereWithIncreasedAccess(className);
		*/
	}

	public static void reflectHere(String className) {
		try {
			// get the class
			Class<?> clazz = getClasss(className);

			// OtherClass oc = new OtherClass();

			// Make the object
			Object clazzInstance = clazz.newInstance();

			// Find the doStuff Method
			Method method = clazz.getMethod("doStuff", String.class);

			// Object result = method.invoke(clazzInstance, new
			// Object[]{"hello" });
			Object result = method.invoke(clazzInstance, "hello");

			// print the results
			System.out.println("InvocationWithSecurity: " + className
					+ " dostuff result: " + result);

			messWithFields(clazzInstance, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(clazzInstance);
	}

	private static Class<?> getClasss(String className)
			throws ClassNotFoundException {
		Class<?> returnValue = null;
		returnValue = Class.forName(className);
		return returnValue;
	}

	@SuppressWarnings("unused")
	private static void messWithFields(Object clazzInstance, Class<?> clazz)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		Field[] allFields = clazz.getDeclaredFields();

		for (Field f : allFields) {
			System.out.println("InvocationWithSecurity: " + f);
		}

		Field field = clazz.getDeclaredField("i");
		field.setAccessible(true);
		field.set(clazzInstance, new Integer(100));
		System.out.println("InvocationWithSecurity: i after changing is "
				+ field.get(clazzInstance));
	}

	public static void reflectThere(String className) {
		SneakyReflector sr = new SneakyReflector();
		sr.innocentLookingMethodCall(className);
	}

	public static void reflectThereWithIncreasedAccess(final String className) {
		SneakyReflector sr = new SneakyReflector();
		sr.innocentMethodWithHeightenedAccess(className);
	}
}
