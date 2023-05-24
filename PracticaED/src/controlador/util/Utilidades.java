/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.util;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author sergio
 */
public class Utilidades {

    public static void imprimir(ListaEnlazada<Object> objs) throws VacioException, PosicionException {
        System.out.println("Lista de " + objs.get(0).getClass().getSimpleName());
        for (int i = 0; i < objs.size(); i++) {
            Object o = objs.get(i);
            System.out.println(o.toString());
        }
    }

    public static Double sumarVentas(Sucursal s) throws VacioException, PosicionException {
        if (s.getVentas() != null) {
            Double ventas = 0.0;
            ListaEnlazada<Venta> ventasList = s.getVentas();
            for (int i = 0; i < ventasList.size(); i++) {
                Venta v = (Venta) ventasList.get(i);
                ventas += v.getValor();
            }
            return ventas;
        }
        return 0.0;
    }
        public static Double mediaVentas(Sucursal s) throws VacioException, PosicionException {
        Double suma = sumarVentas(s);
        if (suma == 0.0) {
            return suma;
        } else {
            return suma / s.getVentas().size();
        }
    }
}
