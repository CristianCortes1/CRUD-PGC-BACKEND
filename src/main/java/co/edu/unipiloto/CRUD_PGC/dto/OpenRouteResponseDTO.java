package co.edu.unipiloto.CRUD_PGC.dto;

import java.util.List;
import lombok.Data;

@Data
public class OpenRouteResponseDTO {
    private List<Feature> features;

    @Data
    public static class Feature {
        private Properties properties;
    }

    @Data
    public static class Properties {
        private Summary summary;
    }

    @Data
    public static class Summary {
        private Double distance;
    }
}