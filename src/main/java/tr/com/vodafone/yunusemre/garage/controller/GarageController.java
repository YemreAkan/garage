package tr.com.vodafone.yunusemre.garage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tr.com.vodafone.yunusemre.garage.model.Ticket;
import tr.com.vodafone.yunusemre.garage.service.IGarageService;

@RestController
@RequestMapping("/garage")
public class GarageController {
	
	@Autowired
	private IGarageService garageService;

	@PostMapping("/park")
	public ResponseEntity<String> park(@RequestBody ParkRequest parkRequest){
		String result = null;
		try {
			Ticket ticket = garageService.park(parkRequest.getPlate(), parkRequest.getColour(), parkRequest.getType());
			if(ticket == null) {
				return new ResponseEntity<String>("Garage is full.", HttpStatus.UNAUTHORIZED);
			} else {
				return new ResponseEntity<String>(ticket.getAllocationMessage(), HttpStatus.OK);
			}
		} catch (Exception e) {
			result = e.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/status")
	public ResponseEntity<List<String>> status(){
		List<Ticket> tickets = garageService.status();
		List<String> result = new ArrayList<>();

		for(int i = 0; i < tickets.size(); i++) {
			result.add(tickets.get(i).toString());
		}

		return new ResponseEntity<List<String>>(result, HttpStatus.OK);
		
	}

	@DeleteMapping("/leave")
	public ResponseEntity<String> leave(@RequestParam int index){
		try {
			index = index - 1;
			garageService.leave(index);
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

}
