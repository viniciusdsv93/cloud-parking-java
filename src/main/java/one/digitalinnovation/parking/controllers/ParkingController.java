package one.digitalinnovation.parking.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.parking.controllers.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.controllers.dto.ParkingDTO;
import one.digitalinnovation.parking.controllers.mapper.ParkingMapper;
import one.digitalinnovation.parking.models.Parking;
import one.digitalinnovation.parking.services.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

  private final ParkingService parkingService;
  private final ParkingMapper parkingMapper;

  public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
    this.parkingService = parkingService;
    this.parkingMapper = parkingMapper;
  }

  @GetMapping
  @ApiOperation("Find all parkings")
  public ResponseEntity<List<ParkingDTO>> findAll() {
    List<Parking> parkingList = parkingService.findAll();
    List<ParkingDTO> result = parkingMapper.toParkingDtoList(parkingList);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
    Parking parking = parkingService.findById(id);
    ParkingDTO result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.ok(result);
  }

  @PostMapping
  public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingDTO) {
    var parkingCreate = parkingMapper.toParkingCreate(parkingDTO);
    var parking = parkingService.create(parkingCreate);
    var result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
}
