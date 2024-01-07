package be.helb.ahmad.Controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/communication")
public class CommunicationSecondApiController {

    @GetMapping(value = "/households", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHouseHoldById() {
        OkHttpClient client = new OkHttpClient();

        // Utilisez une constante pour l'URL de l'API externe (évite les fautes de frappe)
        String externalApiUrl = "http://localhost:8181/api/households";

        Request request = new Request.Builder()
                .url(externalApiUrl)
                .build();

        try {
            Response response = client.newCall(request).execute();

            // Vérifiez si la réponse est réussie (code 2xx)
            if (response.isSuccessful()) {
                final String responseData = response.body().string();
                return new ResponseEntity<>(responseData, HttpStatus.OK);
            } else {
                // Gérez les codes d'erreur spécifiques si nécessaire
                return new ResponseEntity<>("La demande à l'API externe a échoué", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            // Loggez l'exception ou gérez-la selon les besoins
            e.printStackTrace();
            return new ResponseEntity<>("Une erreur s'est produite lors de la communication avec l'API externe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
