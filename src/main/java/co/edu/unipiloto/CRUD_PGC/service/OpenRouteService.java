package co.edu.unipiloto.CRUD_PGC.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenRouteService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public OpenRouteService(
            RestTemplate restTemplate,
            @Value("${ors.api.key:}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = (apiKey == null || apiKey.isBlank()) ? System.getenv("ORS_API_KEY") : apiKey;
    }

    public double getDrivingDistance(double startLon, double startLat, double endLon, double endLat) {
        if (apiKey == null || apiKey.isBlank()) {
            return 0.0;
        }

        try {
            String url = String.format(
                "https://api.openrouteservice.org/v2/directions/driving-car?api_key=%s&start=%f,%f&end=%f,%f",
                apiKey, startLon, startLat, endLon, endLat
            );

            var response = restTemplate.getForObject(url, co.edu.unipiloto.CRUD_PGC.dto.OpenRouteResponseDTO.class);

            if (response != null && response.getFeatures() != null && !response.getFeatures().isEmpty()) {
                Double distance = response.getFeatures().get(0).getProperties().getSummary().getDistance();
                return distance != null ? distance / 1000.0 : 0.0;
            }
        } catch (Exception e) {
            return 0.0;
        }
        return 0.0;
    }
}