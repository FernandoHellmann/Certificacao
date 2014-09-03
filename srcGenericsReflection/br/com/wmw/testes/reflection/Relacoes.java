package br.com.wmw.testes.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.soap.Addressing;

public class Relacoes {

	public static List<Class> getEntidadesRelacionadas(Class<?> c) {
		List<Class> list = new ArrayList<Class>();
		if (c.isAnnotationPresent(Addressing.class)) {
			list.add(c);
		}
		for (Field field : c.getDeclaredFields()) {
			getEntidades(field, list);
		}
		return list;
	}

	private static void getEntidades(Field field, List<Class> list) {
		Class tipo = field.getType();
		isAnnotationPresent(list, field, tipo);
		if (tipo.getPackage() != null && tipo.getPackage().getName().equals("br.com.wmw.testes.entity") ) {
//				equals(String.class) && !tipo.equals(Integer.class) && !tipo.equals(Double.class) && !tipo.equals(char.class) && !tipo.equals(Boolean.class) && !tipo.equals(int.class)
//				&& !tipo.equals(double.class) && !tipo.equals(boolean.class)) {
			for (Field f : tipo.getDeclaredFields()) {
				getEntidades(f, list);
			}
		}
	}

	private static void isAnnotationPresent(List<Class> list, Field f, Class<?> tipo) {
		if (tipo.isAnnotationPresent(Addressing.class)) {
			list.add(tipo);
		} else if (Collections.class.isAssignableFrom(tipo)) {
			ParameterizedType tipoGenerico = (ParameterizedType) f.getGenericType();
			Class<?> parametroGenerico = (Class) tipoGenerico.getActualTypeArguments()[0];
			if (parametroGenerico.isAnnotationPresent(Addressing.class)) {
				list.add(parametroGenerico);
			}
		}
	}


}
