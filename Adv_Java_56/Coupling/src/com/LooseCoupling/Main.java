package com.LooseCoupling;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car dc=new Car(new DieselEngine());
		dc.startCar();
		
		Car pc=new Car(new PertolEngine());
		pc.startCar();
		
		Car ec=new Car(new ElectricalEngine());
		ec.startCar();
	}

}
