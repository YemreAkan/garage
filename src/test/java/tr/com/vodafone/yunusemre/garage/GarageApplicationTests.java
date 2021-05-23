package tr.com.vodafone.yunusemre.garage;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tr.com.vodafone.yunusemre.garage.controller.GarageController;
import tr.com.vodafone.yunusemre.garage.controller.ParkRequest;


@SpringBootTest
class GarageApplicationTests {
	@Autowired
	private GarageController controller;
	
	@Test
	void testCarPark() {
		
		ParkRequest parkRequest = new ParkRequest();
		parkRequest.setColour("Black");
		parkRequest.setPlate("34-SO-1988");
		parkRequest.setType("Car");
		ResponseEntity<String> response = controller.park(parkRequest);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Allocated 1 slot.");
	}
	@Test
	void testTruckPark() {
		
		ParkRequest parkRequest = new ParkRequest();
		parkRequest.setColour("Red");
		parkRequest.setPlate("34-BO-1987");
		parkRequest.setType("Truck");
		ResponseEntity<String> response = controller.park(parkRequest);
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Allocated 4 slots.");
	}
	@Test
	void testJeepPark() {
		
		ParkRequest parkRequest = new ParkRequest();
		parkRequest.setColour("Blue");
		parkRequest.setPlate("34-VO-2018");
		parkRequest.setType("Jeep");
		ResponseEntity<String> response = controller.park(parkRequest);
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Allocated 2 slots.");
	}
	
	@Test
	void testLeave() {
		
		ResponseEntity<String> response = controller.leave(1);
		
		if(response.getStatusCode() == HttpStatus.OK)
			Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		else
			Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	@Test
	void testStatus() {
		
		ResponseEntity<List<String>> response = controller.status();
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
