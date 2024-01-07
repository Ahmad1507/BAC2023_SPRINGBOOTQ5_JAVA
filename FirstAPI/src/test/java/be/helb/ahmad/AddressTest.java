package be.helb.ahmad;

import be.helb.ahmad.Models.Address;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class AddressTest {

    // Définir l'URL de base une seule fois pour tous les tests
    static {
        RestAssured.baseURI = "http://localhost:8081";
    }

    //Test de get toutes les adresses stockés
    @Test
    public void whenGetAllAddresses_thenReturnOk() {
        RestAssured.given()  //RestAssured bibliotheque de test
                .contentType(ContentType.JSON)// donnée type JSON
                .when()
                .get("/api/addresses") // Endpoit du test
                .then()
                .statusCode(HttpStatus.OK.value());
    }


    //Test de get une adresses par id
    @Test
    public void whenGetAddressById_thenReturnOk() {
        Long addressId = 1L; //en partant du postulat que l'id 1 existe

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/addresses/{id}", addressId)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    //Test post une adresse
    @Test
    public void whenPostAddress_thenReturnCreated() {
        Address newAddress = new Address("Chaussée de Boitsfort 46", "Bruxelles", 1050);
        RestAssured.given()
                .body(newAddress)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/addresses")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    //Test get une adresse par code postal
    @Test
    public void whenGetAddressesByPostalCode_thenReturnOk() {
        int postalCode = 1000; //en partant du postulat que le codepostal 1000 existe

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/addresses/postalCode/{postalCode}", postalCode)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    //Test delete une adresse par id
    @Test
    public void whenDeleteAddress_thenReturnNoContent() {
        Long addressId = 2L;//en partant du postulat que l'id 2 existe

        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/addresses/{id}", addressId)
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }
}
