/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FabricaInstrumento;

import java.util.ArrayList;
import librerias.Consola;

/**
 *
 * @author maxi
 */
public class Fabrica {

    private ArrayList<Sucursal> sucursales;

    public Fabrica() {
        this.sucursales = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal suc) {
        this.sucursales.add(suc);
    }

    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void listarInstrumentos() {
        for (Sucursal suc : sucursales) {
            Consola.escribir(suc.getNombre());
            suc.listarInstrumentos();
        }
    }

    public ArrayList<Instrumento> instrumentosPotTipo(TipoInstrumento tipo) {
        ArrayList<Instrumento> insEncontrados = new ArrayList<>();
        for (Sucursal suc : sucursales) {
            insEncontrados.addAll(suc.instrumentosPotTipo(tipo));
        }
        return insEncontrados;
    }

    public Instrumento borrarInstrumento(String ID) {
        Instrumento borrado = null;
        int i = 0;
        while (i < sucursales.size() && borrado == null) {
            borrado = sucursales.get(i).borrarInstrumento(ID);
            i++;
        }
        return borrado;
    }

    /**
     *
     * @param nombreSuc nombre de la sucursal a encontar.
     * @return Sucursal con el nombre pasado por parametro, null si no se
     * encuentra Sucursal con ese nombre.
     */
    public Sucursal buscarSucursal(String nombreSuc) {
        Sucursal sucEncontrada = null;
        int i = 0;
        while (i < this.sucursales.size() && !(this.sucursales.get(i).getNombre().equalsIgnoreCase(nombreSuc))) {
            i++;
        }
        if (i < this.sucursales.size()) {
            sucEncontrada = this.sucursales.get(i);
        }
        return sucEncontrada;
    }

    public double[] porcInstrumentosPorTipo(String nombreSuc) {
        double[] porcentajes = new double[TipoInstrumento.values().length];
        Sucursal suc = this.buscarSucursal(nombreSuc);
        if (suc != null) {
            porcentajes = suc.porcInstrumentosPorTipo();
        }
        return porcentajes;
    }

}
