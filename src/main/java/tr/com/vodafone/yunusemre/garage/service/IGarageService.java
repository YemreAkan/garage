package tr.com.vodafone.yunusemre.garage.service;

import java.util.List;

import tr.com.vodafone.yunusemre.garage.model.Ticket;

public interface IGarageService {

	public Ticket park(String plate, String colour, String type);

	public void leave(int index);

	public List<Ticket> status();
}
