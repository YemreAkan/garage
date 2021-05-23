package tr.com.vodafone.yunusemre.garage.model;

public class Truck extends Vehicle {

	public Truck(String plate, String colour) {
		super(plate, colour);
	}

	@Override
	public int getRequiredSlots() {
		return 4;
	}
}
