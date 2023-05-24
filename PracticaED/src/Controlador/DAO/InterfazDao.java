/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador.DAO;


import controlador.ed.lista.ListaEnlazada;
import java.io.IOException;

/**
 *
 * @author sergio
 */
public interface InterfazDao <T>{
    public void guardar(T obj) throws IOException;
    public void modificar(T obj, Integer pos);
    public ListaEnlazada<T> listar ();
    public T obtener (Integer id);
}
