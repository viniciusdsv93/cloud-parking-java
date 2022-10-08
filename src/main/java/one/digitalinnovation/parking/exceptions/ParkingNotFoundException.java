package one.digitalinnovation.parking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException {

  public ParkingNotFoundException(String id) {
    super(String.format("Parking not found with id: %s", id));
  }
}
