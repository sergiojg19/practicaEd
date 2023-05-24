/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class AdaptadorDao <T> implements InterfazDao<T>{
    private Conexion conexion;
    private Class<T> clazz;
    private String url;

    public AdaptadorDao(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL+clazz.getSimpleName().toLowerCase()+".json";
    }

    @Override
    public void guardar(T obj) throws IOException {
        ListaEnlazada<T> lista = listar();
        lista.insertar(obj);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);   
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    @Override
    public void modificar(T obj, Integer pos) {
        ListaEnlazada<T> lista = listar();
        try {
            lista.modificar(obj, pos);
            conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);   
            conexion.getXstream().toXML(lista, new FileWriter(url));
        } catch (PosicionException | IOException ex) {
            Logger.getLogger(ex.getMessage());
        } 
    }

    @Override
    public ListaEnlazada listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            lista = (ListaEnlazada<T>)conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public T obtener(Integer id) {
        try {
            ListaEnlazada<T> lista = listar();
            T obj = lista.get(id);
            return (T) obj;
        } catch (VacioException ex) {
            Logger.getLogger(AdaptadorDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionException ex) {
            Logger.getLogger(AdaptadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
