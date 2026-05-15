package co.edu.unipiloto.CRUD_PGC.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @Value("${local.server.port:${server.port:8080}}")
    private String port;

    @GetMapping("/server")
    public Map<String, String> server() {
        return Map.of("port", port);
    }
}
