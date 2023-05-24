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
public class ColaI<E> extends ListaEnlazada<E>{
    private Integer tope;

    public ColaI() {
    }

    public ColaI(Integer tope) {
        this.tope = tope;
    }
    
    public Boolean isFull(){
        return (size() >= tope); 
    }
    
    public void queue(E dato) throws TopeException{
        if (isFull()) 
            throw new TopeException("Cola sin espacio");
        
        else 
            this.insertar(dato);
        
    }
    
    public E dequeue() throws VacioException, PosicionException{
        if(isEmpty()){
            throw new VacioException("Cola vacia");
        }
        else {
            return this.delete(0);
        }
    }


    public Integer getTope() {
        return tope;
    }

    public void setTope(Integer tope) {
        this.tope = tope;
    }
    
    
}
