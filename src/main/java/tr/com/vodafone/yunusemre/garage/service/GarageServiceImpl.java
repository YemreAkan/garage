package tr.com.vodafone.yunusemre.garage.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import tr.com.vodafone.yunusemre.garage.model.*;

@Component
public class GarageServiceImpl implements IGarageService {

	private static Garage GARAGE = new Garage(10);
	private static List<Ticket> TICKETS = new ArrayList<>();

	@Override
	public Ticket park(String plate, String colour, String type) {
		Vehicle vehicle = buildVehicle(plate, colour, type);
		
		if(vehicle == null) {
			throw new RuntimeException("Vehicle can not be built");
		}
		int requiredSlots = vehicle.getRequiredSlots();
		Ticket ticket = null;
		boolean vehicleFound = false;
		int vehicleCount = 0;
		int lastIndex = GARAGE.getSlots().length - requiredSlots;
		for(int i = 0; i < lastIndex; i++) {
			// if slot is not empty
			if(GARAGE.getSlots()[i]) {
				vehicleFound = true;
			} else {
				// vehicle found
				if(vehicleFound) {
					vehicleCount++;
					vehicleFound = false;
				}

				boolean slotFound = true;
				// start from next slot if it is not 0 index
				int startIndex = i == 0 ? i: i+1;
				for(int j = startIndex; j < startIndex + requiredSlots; j++) {
					if(GARAGE.getSlots()[j]) {
						slotFound = false;
						break;
					}
				}
				if(slotFound) {
					List<Integer> slots = new ArrayList<>();
					for(int j = startIndex; j < startIndex + requiredSlots; j++) {
						GARAGE.getSlots()[j] = true;
						slots.add(j);
					}
					ticket = new Ticket(vehicle, slots);
					TICKETS.add(vehicleCount, ticket);
					break;
				}

			}
		}

		return ticket;
	}

	private Vehicle buildVehicle(String plate, String colour, String type) {
		Vehicle vehicle = null;
		switch (type) {
			case "Car":
				vehicle = new Car(plate, colour);
				break;
			case "Jeep":
				vehicle = new Jeep(plate, colour);
				break;
			case "Truck":
				vehicle = new Truck(plate, colour);
				break;
		}

		return vehicle;
	}

	@Override
	public void leave(int index) {
		int ticketsSize = TICKETS.size();
		if(index < 0 || index >= ticketsSize) {
			throw new RuntimeException("Invalid leave request");
		}
		Ticket ticket = TICKETS.remove(index);
		for (int slot: ticket.getSlots()) {
			GARAGE.getSlots()[slot] = false;
		}
	}

	@Override
	public List<Ticket> status() {
		return TICKETS;
	}
}
