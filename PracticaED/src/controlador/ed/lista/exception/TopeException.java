/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista.exception;

/**
 *
 * @author sergio
 */
public class TopeException extends Exception{

    public TopeException() {
        super ("La pila esta llena");
    }
    
    public TopeException(String msg){
        super(msg);
    }
}
