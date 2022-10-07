package one.digitalinnovation.parking.services;

import one.digitalinnovation.parking.models.Parking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ParkingService {

  private static Map<String, Parking> parkingMap = new HashMap<>();

  static {
    var id = getUUID();
    Parking parking = new Parking(id, "DMS-1111", "SC", "Celta", "Black");
    parkingMap.put(id, parking);
  }

  private static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
