package ttl.reflect.mh;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleDemo {

	
	public static void main(String[] args) throws Throwable {
		MethodHandle goHandle = 
				MethodHandles.lookup().findVirtual(MethodHandleDemo.class, "go", 
					     MethodType.methodType(String.class, int.class));
		
		MethodHandleDemo mhd = new MethodHandleDemo();
		String result = (String)goHandle.invoke(mhd, 10);
		System.out.println("result is " + result);
	}
	
	public String go(int i) {
		return "i is " + i;
	}
}
