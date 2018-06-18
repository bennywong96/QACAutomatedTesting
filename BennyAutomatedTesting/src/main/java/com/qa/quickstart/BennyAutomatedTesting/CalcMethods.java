package com.qa.quickstart.BennyAutomatedTesting;

public class CalcMethods {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public double divide(int a, int b) {
		return (double) a/b;
	}
	
	
	public int modulus1(int a, int b) {
		return a%b;
	}
	
	public int powerOf(double a, double b) {
		return (int) Math.pow(a,b);
	}
	
	
	public int mystery(int a, int b) {
		return ((a+b)+(a-b));
	}
	
}
