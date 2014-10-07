package com.talosdigital.test;


import com.talosdigital.logic.Example;
import com.talosdigital.reflection.Reflection;

import org.junit.Test;
/**
 * 
 * @author juandavidhenao
 * @version 02/10/2014
 */
public class ReflectionTest {

	/**
	 * this method test the reflection method
	 */
	@Test
	public void test() {
		com.talosdigital.logic.Example examp = new Example();
		Reflection.getObjectDetails(examp);
	}

}
