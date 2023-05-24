/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import controlador.ed.cola.Cola;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.TopeException;
import controlador.ed.lista.exception.VacioException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class AdaptadorDaoCola<E> {
    private int tope = 10;
    private Conexion conexion;
    private Class clazz;
    private String url;
    
    public AdaptadorDaoCola(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }
    
    public void queue(E obj) throws IOException, TopeException {
        Cola<E> cola = listar();
        cola.queue(obj);
        conexion.getXstream().alias(cola.getClass().getName(), Cola.class);
        conexion.getXstream().toXML(cola, new FileWriter(url));
    }

    
    public Cola<E> listar() {
        Cola<E> cola = new Cola<>(tope);
        try {
            cola = (Cola<E>) conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cola;
    }

    public void dequeue() throws VacioException, PosicionException {
        Cola<E> cola = listar();
        try {
            cola.dequeue();
            conexion.getXstream().alias(cola.getClass().getName(), Cola.class);
            conexion.getXstream().toXML(cola, new FileWriter(url));
        } catch (PosicionException | IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
   
    
    public void guardarCola(Cola<E> cola) throws IOException {
        conexion.getXstream().alias(cola.getClass().getName(), Cola.class);
        conexion.getXstream().toXML(cola, new FileWriter(url));
    }
    
    
}
