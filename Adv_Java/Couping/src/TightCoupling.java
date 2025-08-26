class Engine{
	public void ElectricEngine() {
		System.out.println("ElectricEngine Start....");
	}
	public void PetrolEngine() {
		System.out.println("PetrolEngine Start....");
	}
}

public class TightCoupling {
	Engine obj=new Engine();
	public void car() {
		obj.PetrolEngine();
		System.out.println("Car started ....");
	}
	public static void main(String[] args) {
		TightCoupling car=new TightCoupling();
		car.car();
	}
}
