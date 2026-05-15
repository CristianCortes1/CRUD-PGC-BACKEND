package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.SubsidyResponseDTO;
import co.edu.unipiloto.CRUD_PGC.service.SubsidyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subsidies")
public class SubsidyController {

    private final SubsidyService subsidyService;

    @GetMapping("/{id}")
    public ResponseEntity<SubsidyResponseDTO> getSubsidyById(@PathVariable int id) {
        SubsidyResponseDTO response = subsidyService.getSubsidyById(id);
        return ResponseEntity.ok(response);
    }
}