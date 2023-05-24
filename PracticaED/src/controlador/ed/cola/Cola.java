/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.cola;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.TopeException;
import controlador.ed.lista.exception.VacioException;
import controlador.ed.lista.ListaEnlazada;
/**
 *
 * @author sergio
 */
public class Cola<E> {
    private ColaI<E> cola;
    
    public Cola(Integer tope) {
        cola = new ColaI<>(tope);
    }
    
    public void queue(E obj) throws TopeException{
        cola.queue(obj);
    }
    
    public E dequeue() throws VacioException, PosicionException{
        return  cola.dequeue();
    }
    
    public Integer getTope(){
        return cola.getTope();
    }
    
    public void print () throws VacioException{
        cola.imprimir();
    }

    public ColaI<E> getCola() {
        return cola;
    }

 
    public void setCola(ColaI<E> cola) {
        this.cola = cola;
    }
    
    
}
