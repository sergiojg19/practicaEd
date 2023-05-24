/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import modelo.Sucursal;
import modelo.Venta;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.util.Utilidades;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sergio
 */


public class ModeloTablaSucursal extends AbstractTableModel {
    private ListaEnlazada<Sucursal> datos = new ListaEnlazada<>();

    public ModeloTablaSucursal() {
        datos = new ListaEnlazada<>();
    }
    
    
    
    public ListaEnlazada<Sucursal> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Sucursal> datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Sucursal s = (Sucursal) datos.get(i);
            switch (i1) {
                case 0:
                    return (s != null) ? s.getNombre() : "NO DEFINIDO";
                case 1:
                    return (s != null) ? Utilidades.sumarVentas(s) : 0.0;
                case 2:
                    return (s != null) ? Utilidades.mediaVentas(s) : 0.0;
                default:
                    return null;
            }
        } catch (VacioException | PosicionException ex) {
            Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Sucursal";
            case 1:
                return "Venta Anual";
            case 2:
                return "Venta Promedio";
            default:
                return null;
        }
    }
}
