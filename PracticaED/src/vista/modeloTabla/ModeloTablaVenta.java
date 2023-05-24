/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.util.Utilidades;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Venta;


/**
 *
 * @author sergio
 */


public class ModeloTablaVenta extends AbstractTableModel {

    private ListaEnlazada<Venta> datos = new ListaEnlazada<>();

    public ModeloTablaVenta() {
    }

    public ListaEnlazada<Venta> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Venta> datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Venta v = (Venta) datos.get(rowIndex);
            switch (columnIndex) {
            case 0:
                return (v != null) ? v.getMes().toString() : "NO DEFINIDO";
            case 1:
                return (v != null) ? v.getValor() : 0.0;
            default:
                return null;
        }
            
        } catch (VacioException | PosicionException ex) {
            Logger.getLogger(ModeloTablaVenta.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Mes";
            case 1:
                return "Valor";
            default:
                return null;
        }
    }
}
