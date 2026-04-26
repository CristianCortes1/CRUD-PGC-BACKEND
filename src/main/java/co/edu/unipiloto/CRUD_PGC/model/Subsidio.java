package co.edu.unipiloto.CRUD_PGC.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cristian-cortes
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subsidio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double porcentaje; 

    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
