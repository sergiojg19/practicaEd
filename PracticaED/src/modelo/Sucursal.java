/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ed.lista.ListaEnlazada;
import modelo.Venta;

/**
 *
 * @author sergio
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private ListaEnlazada<Venta> ventas;

    public Sucursal() {
        this.ventas = new ListaEnlazada<Venta>();
    }

    public Sucursal(Integer id, String nombre, ListaEnlazada<Venta> ventas) {
        this.id = id;
        this.nombre = nombre;
        this.ventas = ventas;
    }
    
    

    public ListaEnlazada<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ListaEnlazada<Venta> ventas) {
        this.ventas = ventas;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre+" "+id; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
