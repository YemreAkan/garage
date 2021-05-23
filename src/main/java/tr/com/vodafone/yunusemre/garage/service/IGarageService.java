package tr.com.vodafone.yunusemre.garage.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import tr.com.vodafone.yunusemre.garage.controller.ParkRequest;
import tr.com.vodafone.yunusemre.garage.model.Ticket;
import tr.com.vodafone.yunusemre.garage.model.Vehicle;

public interface IGarageService {

	public Ticket park(String plate, String colour, String type);

	public void leave(int index);

	public List<Ticket> status();
}
