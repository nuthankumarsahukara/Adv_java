package com.tightCoupling;

public class Car {
	Engine e=new Engine();
	public void carStart() {
		e.start();
		System.out.println("Car started....");
	}
	public void electricalCarStart() {
		e.electricalStart();
		System.out.println("Car started....");
	}

}
