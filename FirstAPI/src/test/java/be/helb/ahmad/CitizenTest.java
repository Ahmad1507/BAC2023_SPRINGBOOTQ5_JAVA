package be.helb.ahmad;

import be.helb.ahmad.Models.Citizen;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CitizenTest {
    // Définir l'URL de base une seule fois pour tous les tests
    static {
        RestAssured.baseURI = "http://localhost:8081";
    }
    @Test
    public void whenGetAllCitizens_thenReturnOk() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/citizens")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void whenGetCitizenById_thenReturnOk() {
        Long citizenId = 1L;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/citizens/{id}", citizenId)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void whenPostCitizen_thenReturnCreated() {
        Citizen newCitizen = new Citizen("Ahmad","Abunassar","ahmad.abunassar@example.com");

        RestAssured.given()
                .body(newCitizen)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/citizens")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void whenDeleteCitizen_thenReturnNoContent() {
        Long citizenId = 2L;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/citizens/{id}", citizenId)
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }
}
