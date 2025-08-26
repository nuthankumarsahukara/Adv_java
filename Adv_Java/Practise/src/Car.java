// Engine interface
interface Engine {
    void start();
}

//PetrolEngine class
class PetrolEngine implements Engine {
 public void start() {
     System.out.println("Petrol Engine Started");
 }
}

//ElectricEngine class
class ElectricEngine implements Engine {
 public void start() {
     System.out.println("Electric Engine Started");
 }
}

public class Car {
	 private Engine engine;

	    // Inject the engine through the constructor
	    public Car(Engine engine) {
	        this.engine = engine;
	    }

	    public void startCar() {
	        engine.start();
	        System.out.println("Car Started");
	    }
	    
	public static void main(String[] args) {
		Engine engine = new ElectricEngine(); 
        Car car = new Car(engine);
        car.startCar();
	}

}
