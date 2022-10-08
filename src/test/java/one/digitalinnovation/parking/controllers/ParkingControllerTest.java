package one.digitalinnovation.parking.controllers;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controllers.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest {

  @LocalServerPort
  private int randomPort;

  @BeforeEach
  public void setUpTest() {
    RestAssured.port = randomPort;
  }

  @Test
  void whenFindAllThenCheckResult() {
    RestAssured.given()
            .when()
            .get("/parking")
            .then()
            .statusCode(HttpStatus.OK.value());
  }

  @Test
  void whenCreateThenCheckIsCreated() {

    var createDto = new ParkingCreateDTO();
    createDto.setLicense("AMS-8528");
    createDto.setColor("Yellow");
    createDto.setModel("Civic");
    createDto.setState("AM");

    RestAssured.given()
            .when()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(createDto)
            .post("/parking")
            .then()
            .statusCode(HttpStatus.CREATED.value())
            .body("license", Matchers.equalTo("AMS-8528"))
            .body("color", Matchers.equalTo("Yellow"))
            .body("model", Matchers.equalTo("Civic"))
            .body("state", Matchers.equalTo("AM"));
  }
}