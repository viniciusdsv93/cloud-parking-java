package one.digitalinnovation.parking.controllers;

import one.digitalinnovation.parking.models.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

  @GetMapping
  public List<Parking> listAll() {

    var parking = new Parking();
    parking.setColor("Black");
    parking.setLicense("MSC-1111");
    parking.setModel("VW Gol");
    parking.setState("SP");

    List<Parking> list = new ArrayList<>();
    list.add(parking);
    return list;
  }
}
