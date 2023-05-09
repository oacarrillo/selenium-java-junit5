/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	Calculator ecuacion = new Calculator();
	@BeforeAll
	static void antesTodo(){
		System.out.println("antes todo");
	}
	@AfterAll
	static void despuesTodo(){
		System.out.println("despues todo");
	}

	@BeforeEach
	void antesMetodo(){
		System.out.println("antes metodo");
	}

	@AfterEach
	void despuesMetodo(){
		System.out.println("despues metodo");
	}

	@Test// hace que el metodo sea un metodo de prueba
	@DisplayName("Prueba 1 = 1 + 1 = 2") // DAr un nombre a la prueba
	void addsTwoNumbers() {
		int i=ecuacion.resta(1,2);
		assertEquals(2, ecuacion.add(1, 1), "1 + 1 should equal 2");
		System.out.println("suma1");
	}

	@Test// hace que el metodo sea un metodo de prueba
	@DisplayName("Prueba 2 = 1 + 1 = 2") // DAr un nombre a la prueba
	void addsTwoNumbers2() {

		assertEquals(3, ecuacion.add(1, 2), "1 + 1 should equal 2");
		System.out.println("suma2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {

		assertEquals(expectedResult, ecuacion.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
		System.out.println("suma3");
	}
}
