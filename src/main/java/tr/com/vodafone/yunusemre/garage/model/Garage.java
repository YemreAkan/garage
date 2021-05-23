package tr.com.vodafone.yunusemre.garage.model;

public class Garage {
    private boolean[] slots;

    public Garage(int size) {
        slots = new boolean[size];
    }

    public boolean[] getSlots() {
        return slots;
    }
}
