package one.digitalinnovation.parking.controllers.mapper;

import one.digitalinnovation.parking.controllers.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.controllers.dto.ParkingDTO;
import one.digitalinnovation.parking.models.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

  private static final ModelMapper MODEL_MAPPER = new ModelMapper();

  public ParkingDTO toParkingDTO(Parking parking) {
    return MODEL_MAPPER.map(parking, ParkingDTO.class);
  }

  public List<ParkingDTO> toParkingDtoList(List<Parking> parkingList) {
    return parkingList.stream().map(item -> toParkingDTO(item)).collect(Collectors.toList());
  }

  public Parking toParking(ParkingDTO parkingDTO) {
    return MODEL_MAPPER.map(parkingDTO, Parking.class);
  }

  public Parking toParkingCreate(ParkingCreateDTO parkingCreateDTO) {
    return MODEL_MAPPER.map(parkingCreateDTO, Parking.class);
  }
}
