package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Principal {

	private double doubl;
	public static final int in = 37;
	String string = "testing";

	public static void main(String[] args) {
		getClassMethods();
		getNmAtributosClasse();
		callMethodByName();
		testeConstrutor();
	}

	public static void getClassMethods() {
		try {
			Class c = Class.forName("Reflection.Principal");
			Method m[] = c.getDeclaredMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i].toString());
			}
			System.out.println("##########################################################################################");
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	public static void getNmAtributosClasse() {
		try {
			Class cls = Class.forName("Reflection.Principal");

			Field fieldlist[] = cls.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) {
				Field field = fieldlist[i];
				System.out.println("nome atributo = " + field.getName());
				System.out.println("membro da classe = " + field.getDeclaringClass());
				System.out.println("tipo = " + field.getType());
				int mod = field.getModifiers();
				System.out.println("modificadores = " + Modifier.toString(mod));
				System.out.println("-------------------------------------------");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}



	    public static void callMethodByName() {
	        try {
	            Class partypes[] = new Class[2];
	            partypes[0] = Integer.TYPE;
	            partypes[1] = Integer.TYPE;

	            Class cls = Class.forName("Reflection.InvocaMetodo");
	            Method meth = cls.getMethod("umMetodo", partypes);

	            Object arglist[] = new Object[2];
	            arglist[0] = new Integer(37);
	            arglist[1] = new Integer(47);

	            InvocaMetodo methobj = new InvocaMetodo();
	            Object retobj = meth.invoke(methobj, arglist);
	            Integer retval = (Integer)retobj;
	            System.out.println(retval.intValue());
	        }
	        catch (Throwable e) {
	            System.err.println(e);
	        }

	    }


	    public static void testeConstrutor() {
	        try {
	        	Class cls1 = Class.forName("Reflection.TesteConstrutor");
	            Class cls = Class.forName("Reflection.TesteConstrutor");

	            Class partypes[] = new Class[2];
	            partypes[0] = Integer.TYPE;
	            partypes[1] = Integer.TYPE;

	            Constructor ct1 = cls.getConstructor();
	            Constructor ct = cls.getConstructor(partypes);

	            Object arglist[] = new Object[2];
	            arglist[0] = new Integer(37);
	            arglist[1] = new Integer(47);

	            ct1.newInstance();
	            Object retobj = ct.newInstance(arglist);
	        }
	        catch (Throwable e) {
	            System.err.println(e);
	        }
	    }

}
