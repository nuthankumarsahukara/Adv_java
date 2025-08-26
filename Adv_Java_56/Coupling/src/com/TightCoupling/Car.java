package com.TightCoupling;

public class Car {
	Engine e=new Engine();
	public void startCar() {
		e.start();
		System.out.println("Car Started...");
	}
	public void electricalStartCar() {
		e.electricalStart();
		System.out.println("Car Started...");
	}
}
