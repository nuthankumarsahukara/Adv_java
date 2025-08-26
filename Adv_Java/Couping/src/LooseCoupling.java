interface EngineEx{
	void start();
}

class PetrolEngine implements EngineEx {
    public void start() {
        System.out.println("Petrol Engine Started");
    }
}

class ElectricEngine implements EngineEx {
    public void start() {
        System.out.println("Petrol Engine Started");
    }
    
}

class HybridEngine implements EngineEx {
    public void start() {
        System.out.println("Hybrid Engine Started");
    }
    
}

public class LooseCoupling {
	private EngineEx obj;
	public LooseCoupling(EngineEx obj) {
        this.obj = obj;
    }
	public void startCar() {
        obj.start();
        System.out.println("Car Started");
    }
	public static void main(String[] args) {		 
	     LooseCoupling obj1 = new LooseCoupling(new HybridEngine());
	     obj1.startCar();
	}
}
