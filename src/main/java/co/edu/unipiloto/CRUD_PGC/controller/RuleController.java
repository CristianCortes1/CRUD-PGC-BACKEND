/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.RuleRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.RuleResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.RuleMapper;
import co.edu.unipiloto.CRUD_PGC.model.Rule;
import co.edu.unipiloto.CRUD_PGC.service.RuleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/api/rules")
@RequiredArgsConstructor
public class RuleController {
    public final RuleService ruleService;
    
    @GetMapping
    public List<RuleResponseDTO> getAllRules(){
    return ruleService.getAllRules();
    }
    
    @PostMapping
    public RuleResponseDTO saveRule(@RequestBody RuleRequestDTO dto){
        Rule rule = ruleService.saveRule(dto);
    return RuleMapper.toDTO(rule);
    }
}
