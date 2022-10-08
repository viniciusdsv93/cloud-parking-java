package one.digitalinnovation.parking.controllers;

import one.digitalinnovation.parking.controllers.dto.ParkingDTO;
import one.digitalinnovation.parking.controllers.mapper.ParkingMapper;
import one.digitalinnovation.parking.models.Parking;
import one.digitalinnovation.parking.services.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parking")
public class ParkingController {

  private final ParkingService parkingService;
  private final ParkingMapper parkingMapper;

  public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
    this.parkingService = parkingService;
    this.parkingMapper = parkingMapper;
  }

  @GetMapping
  public List<ParkingDTO> findAll() {
    List<Parking> parkingList = parkingService.findAll();
    List<ParkingDTO> result = parkingMapper.toParkingDtoList(parkingList);
    return result;
  }
}
