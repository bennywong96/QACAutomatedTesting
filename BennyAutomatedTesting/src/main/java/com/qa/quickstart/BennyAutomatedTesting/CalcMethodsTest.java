package com.qa.quickstart.BennyAutomatedTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcMethodsTest {
	CalcMethods lol = new CalcMethods();

	@Test
	public void testAdd() {
		int x = 1;
		int y = 2;
		assertEquals(3, lol.add(x,y));
	}

	@Test
	public void testAdd2() {
		int x = 3;
		int y = 5;
		assertEquals(8, lol.add(x,y));
	}
	@Test
	public void testSubtract() {
		int x = 6;
		int y = 5;
		assertEquals(1, lol.subtract(x,y));
	}
	@Test
	public void testSubtract2() {
		int x = 6;
		int y = 3;
		assertEquals(3, lol.subtract(x,y));
	}
	@Test
	public void testMultiply() {
		int x = 2;
		int y = 2;
		assertEquals(4, lol.multiply(x,y));
	}
	@Test
	public void testMultiply2() {
		int x = 3;
		int y = 2;
		assertEquals(6, lol.multiply(x,y));
	}
	@Test
	public void testDivide() {
		int x = 3;
		int y = 3;
		assertEquals(1, lol.divide(x,y), 0);
	}
	@Test
	public void testDivide2() {
		int x = 4;
		int y = 2;
		assertEquals(2, lol.divide(x,y), 0);
	}
	@Test
	public void testModulus1() {
		int x = 5;
		int y = 2;
		assertEquals(1, lol.modulus1(x,y));
	}
	@Test
	public void testModulus2() {
		int x = 5;
		int y = 5;
		assertEquals(0, lol.modulus1(x,y));
	}
	@Test
	public void testPowerOf() {
		int x = 5;
		int y = 2;
		assertEquals(25, lol.powerOf(x,y));
	}
	@Test
	public void testPowerOf2() {
		int x = 2;
		int y = 2;
		assertEquals(4, lol.powerOf(x,y));
	}
	@Test
	public void testMystery() {
		int x = 2;
		int y = 2;
		assertEquals(4, lol.mystery(x,y));
	}
	@Test
	public void testMystery2() {
		int x = 1;
		int y = 1;
		assertEquals(2, lol.mystery(x,y));
	}
}
