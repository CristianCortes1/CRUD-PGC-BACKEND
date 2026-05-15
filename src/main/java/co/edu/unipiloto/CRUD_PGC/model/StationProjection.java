/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.model;

/**
 *
 * @author cristian-cortes
 */
public interface StationProjection {

    Long getId();

    String getNombre();
    String getDireccion();

    Double getLatitud();
    Double getLongitud();
    Double getDistancia();

    Double getPrecioCorriente();
    Double getPrecioExtra();
    Double getPrecioDiesel();
    Double getPrecioGNV();
}
