package tr.com.vodafone.yunusemre.garage.model;

public class Jeep extends Vehicle {

	public Jeep(String plate, String colour) {
		super(plate, colour);
	}

	@Override
	public int getRequiredSlots() {
		return 2;
	}

}
