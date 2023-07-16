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
public class Sucursal {

    private String nombre;
    private ArrayList<Instrumento> instrumentos;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.instrumentos = new ArrayList<>();
    }

    public void agregarInstrumento(Instrumento instrumento) {
        this.instrumentos.add(instrumento);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void listarInstrumentos() {
        for (Instrumento inst : instrumentos) {
            Consola.escribir(inst);
        }
    }

    public ArrayList<Instrumento> instrumentosPotTipo(TipoInstrumento tipo) {
        ArrayList<Instrumento> insEncontrados = new ArrayList<>();
        for (Instrumento inst : instrumentos) {
            if (inst.getTipo().equals(tipo)) {
                insEncontrados.add(inst);
            }
        }
        return insEncontrados;
    }

    public Instrumento borrarInstrumento(String ID) {
        Instrumento insABorrar = this.buscarInstrumento(ID);
        this.instrumentos.remove(insABorrar);
        return insABorrar;
    }

    public Instrumento buscarInstrumento(String ID) {
        Instrumento insEncontrado = null;
        int i = 0;
        while (i < this.instrumentos.size() && !(instrumentos.get(i).getID().equals(ID))) {
            i++;
        }
        if (i < instrumentos.size()) {
            insEncontrado = instrumentos.get(i);
        }
        return insEncontrado;
    }

    private double porcInstrumentoDeTipo(TipoInstrumento tipo) {
        ArrayList<Instrumento> lista = instrumentosPotTipo(tipo);
        return lista.size() / (double) instrumentos.size();
    }

    public double[] porcInstrumentosPorTipo() {
        final int CANT_INSTRUMENTOS = TipoInstrumento.values().length;
        double[] porcentajes = new double[CANT_INSTRUMENTOS];

        for (Instrumento instrumento : instrumentos) {
            porcentajes[instrumento.getTipo().ordinal()]++;
        }
        return absolutoAPorcentaje(porcentajes);
    }
    
    private double [] absolutoAPorcentaje(double[] porcentajes){
        for (int i = 0; i < porcentajes.length; i++) {
            porcentajes[i] = (porcentajes[i] * 100) / instrumentos.size();
           // porcentajes[i] /= TipoInstrumento.values().length;
        }
        return porcentajes;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "nombre=" + nombre + '}';
    }

}
