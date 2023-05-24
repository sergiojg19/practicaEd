/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.NodoLista;

import controlador.exception.EspacioException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author sergio
 */
public class SucursalControl {
    private ListaEnlazada<Sucursal> sucursales;
    private Sucursal sucursal;
    private Venta venta;
    private ListaEnlazada<Venta> ventas;

    public SucursalControl() {
        this.sucursales = new ListaEnlazada<>();
        this.ventas = new ListaEnlazada<>();
    }
    
    

    public SucursalControl(ListaEnlazada<Sucursal> sucursales, Sucursal sucursal, Venta venta, ListaEnlazada<Venta> ventas) {
        this.sucursales = sucursales;
        this.sucursal = sucursal;
        this.venta = venta;
        this.ventas = ventas;
    }

    
    
    /**
     * @return the sucursal
     */
    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the sucursales
     */
    public ListaEnlazada<Sucursal> getSucursales() {
        return sucursales;
    }

    /**
     * @param sucursales the sucursales to set
     */
    public void setSucursales(Sucursal sucursales) {
        this.setSucursales(sucursales);
    }

    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public boolean registrar() throws EspacioException {
        int pos = -1;
        int cont = -1;
        NodoLista<Sucursal> nodoSucursal = getSucursales().getCabecera();
        while (nodoSucursal != null) {
            cont++;
            Sucursal s = nodoSucursal.getInfo();
            if (s == null) {
                pos = cont;
                break;
            }
            nodoSucursal = nodoSucursal.getSig();
        }

        if (pos == -1) {
            throw new EspacioException();
        }

        getSucursal().setVentas(new ListaEnlazada<>());

        for (EnumMes mes : EnumMes.values()) {
            Venta venta = new Venta();
            venta.setId(mes.ordinal() + 1);
            venta.setMes(mes);
            venta.setValor(0.0);
            getSucursal().getVentas().insertar(venta);
        }

        getSucursales().insertar(getSucursal());
        return true;
    }

//    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException {
//        if (this.sucursal != null) {
//            ListaEnlazada<Venta> ventas = this.sucursal.getVentas();
//            if (posVenta <= ventas.size() - 1) {
//                ventas.get(posVenta).setValor(valor);
//            } else {
//                throw new EspacioException();
//            }
//        } else {
//            throw new NullPointerException("Debe seleccionar una sucursal");
//        }
//        return true;
//    }
    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException {
        if (getSucursal() != null) {
            if (posVenta >= 0 && posVenta < getSucursal().getVentas().size()) {
                NodoLista<Venta> nodoVenta = getSucursal().getVentas().getCabecera();
                for (int i = 0; i < posVenta; i++) {
                    nodoVenta = nodoVenta.getSig();
                }
                Venta venta = nodoVenta.getInfo();
                venta.setValor(valor);
            } else {
                throw new EspacioException();
            }
        } else {
            throw new NullPointerException("Debe seleccionar una sucursal");
        }
        return true;
    }

    /**
     * @param sucursales the sucursales to set
     */
    public void setSucursales(ListaEnlazada<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    /**
     * @return the ventas
     */
    public ListaEnlazada<Venta> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(ListaEnlazada<Venta> ventas) {
        this.ventas = ventas;
    }
    
    

}
