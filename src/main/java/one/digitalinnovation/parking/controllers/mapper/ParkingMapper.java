package one.digitalinnovation.parking.controllers.mapper;

import one.digitalinnovation.parking.controllers.dto.ParkingDTO;
import one.digitalinnovation.parking.models.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

  private static final ModelMapper MODEL_MAPPER = new ModelMapper();

  public ParkingDTO parkingDTO(Parking parking) {
    return MODEL_MAPPER.map(parking, ParkingDTO.class);
  }

  public List<ParkingDTO> toParkingDtoList(List<Parking> parkingList) {
    return parkingList.stream().map(item -> parkingDTO(item)).collect(Collectors.toList());
  }
}
