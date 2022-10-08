package one.digitalinnovation.parking.services;

import one.digitalinnovation.parking.controllers.dto.ParkingDTO;
import one.digitalinnovation.parking.models.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

  private static Map<String, Parking> parkingMap = new HashMap<>();

  static {
    var id = getUUID();
    var id1 = getUUID();
    Parking parking = new Parking(id, "DMS-1111", "SC", "Celta", "Black");
    Parking parking1 = new Parking(id1, "XNS-2222", "SP", "Gol", "Red");
    parkingMap.put(id, parking);
    parkingMap.put(id1, parking1);
  }

  private static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public List<Parking> findAll() {
    return parkingMap.values().stream().collect(Collectors.toList());
  }

  public Parking findById(String id) {
    return parkingMap.get(id);
  }

  public Parking create(Parking parkingCreate) {
    String uuid = getUUID();
    parkingCreate.setId(uuid);
    parkingCreate.setEntryDate(LocalDateTime.now());
    parkingMap.put(uuid, parkingCreate);
    return parkingCreate;
  }
}
