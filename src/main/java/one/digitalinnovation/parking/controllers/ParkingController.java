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
  @ApiOperation("Find one parking")
  public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
    Parking parking = parkingService.findById(id);
    ParkingDTO result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("Delete one parking")
  public ResponseEntity delete(@PathVariable String id) {
    parkingService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  @ApiOperation("Create one parking")
  public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingDTO) {
    var parkingCreate = parkingMapper.toParkingCreate(parkingDTO);
    var parking = parkingService.create(parkingCreate);
    var result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @PutMapping("/{id}")
  @ApiOperation("Update one parking")
  public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingDTO) {
    var parkingCreate = parkingMapper.toParkingCreate(parkingDTO);
    var parking = parkingService.update(id, parkingCreate);
    var result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @PostMapping("/{id}")
  @ApiOperation("Checkout parking")
  public ResponseEntity<ParkingDTO> exit(@PathVariable String id) {
    Parking parkingExit = parkingService.checkout(id);
    ParkingDTO parkingExitFormatted = parkingMapper.toParkingDTO(parkingExit);
    return ResponseEntity.status(HttpStatus.OK).body(parkingExitFormatted);
  }
}
