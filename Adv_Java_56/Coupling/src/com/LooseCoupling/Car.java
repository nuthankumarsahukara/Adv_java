package com.LooseCoupling;

public class Car {
	Engine e;
	public Car(Engine e) {
		this.e=e;
	}
	public void startCar() {
		e.engine();
		System.out.println("Car started .....");
	}
}
