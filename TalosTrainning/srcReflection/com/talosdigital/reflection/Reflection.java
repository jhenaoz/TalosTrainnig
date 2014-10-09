package com.talosdigital.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static com.talosdigital.util.LoggerUtil.*;

/**
 * This class is for the test of the reflection API
 * @author jhenaoz
 * @version 02/10/2014
 */
public class Reflection {

	/**
	 * this method receive and object and print in console all the details about
	 * it (methods with params) (class identifier with access modifier)
	 * (Attributes of the class with the respective class identifier)
	 * @param obj, and object to print all the info
	 */
	public static void getObjectDetails(Object obj){
		startLogger("ReflectionFile.log");
		modifierInfo(obj);
		attributesInfo(obj);
		methodsInfo(obj);
	}	
	
	/**
	 * This method print the the type off all the attributes and the name
	 * off the same, it also print private and protected attributes
	 * @param obj
	 */
	private static void attributesInfo(Object obj) {

		log.info("ATTRIBUTES: ");
		Class <? extends Object> reflectedClass = obj.getClass();
		Field[] attr =  reflectedClass.getDeclaredFields();
		for (Field field : attr) {
			field.getType();
			if (((Class<?>)field.getType()).isPrimitive()   ) {
				System.out.println("The field is a primitive");
				log.info(field.getType() + " "+ field.getName());
			}else{
				log.info(field.getType() + " "+ field.getName());
				log.warn("New Object Found...getting info");
				getObjectDetails(field.getType());
			}
		}
		log.info("");
	}

	/**
	 * this method print all the methods of one class, it also include the
	 * Inherits methods 
	 * @param obj
	 */
	public static void methodsInfo(Object obj){
		log.info("METHODS:");
		Class<? extends Object> reflectedClass= obj.getClass();
		Method[] methods = reflectedClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			StringBuilder method = new StringBuilder();
			method.append(methods[i].getName() + "(");
			@SuppressWarnings("rawtypes")
			Class[] type = methods[i].getParameterTypes() ;
			for (int j = 0; j < type.length; j++) {
				method.append(type[j].getName());
				if ((j >= 0) && (j != type.length-1)) {
					method.append(", ");
				}
			}
			method.append(")");
			log.info(method.toString());
		}
	}
	/**
	 * this method return the name of the class, with the location in the package
	 * and also the modifier of the class (public, private , abstract...etc)
	 * @param obj
	 */
	public static void modifierInfo(Object obj){
		System.out.print(obj.getClass() +": ");
		Class<? extends Object> reflectedClass = obj.getClass();
		int modifier = reflectedClass.getModifiers();
		switch (modifier) {
			case Modifier.ABSTRACT:
				System.out.println("Abstract Class");
				break;
			case Modifier.PUBLIC:
				System.out.println("Public Class");
				break;
			case Modifier.PRIVATE:
				System.out.println("Private Class");
				break;
			case Modifier.FINAL:
				System.out.println("Final Class");
				break;
			case Modifier.STATIC:
				System.out.println("Static Class");
				break;
		default:
			log.info("Class Modifier :" + modifier);;
		}
		log.info("");
	}
}
