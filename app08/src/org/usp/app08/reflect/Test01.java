package org.usp.app08.reflect;

// Reflection API
import java.lang.reflect.*;

// JDI (Java Debug Interface)

public class Test01 {
	public static void main(String args[]) throws Exception {
		Class c = Class.forName(args[0]); // loading

		System.out.println("Fields");
		Field field[] = c.getDeclaredFields();

		for (int i = 0; i < field.length; i++) {
			System.out.println(field[i].getType());
			System.out.println(field[i].getName());
			System.out.println();
		}

		Method method[] = c.getDeclaredMethods();

		for (int i = 0; i < method.length; i++) {
			System.out.println(method[i].getName());
			System.out.println();
		}

		Object o = c.newInstance();
		System.out.println(o);
		//Method m = c.getMethod("x");
		//m.invoke(o, m, new Object[]{});
	}
}
