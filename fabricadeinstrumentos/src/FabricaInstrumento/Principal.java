package FabricaInstrumento;

import java.util.ArrayList;
import librerias.Consola;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author maxi
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Fabrica f = new Fabrica();
        cargarFabrica(f);
        f.listarInstrumentos();

//        ArrayList<Instrumento> lista = f.instrumentosPotTipo(TipoInstrumento.VIENTO);
//        for (Instrumento inst : lista) {
//            Consola.escribir(inst);
//        }

        Consola.escribir("\nse borrara el Instrumeto guitarra\n");
        Consola.escribir("Se borro " + f.borrarInstrumento("Guitarra"));
        Consola.escribir("");
//        f.listarInstrumentos();
        Consola.escribir("\n");
        
        Consola.escribir("SE PRUEBA EL METODO PORCINSTRUMENTOSPORTIPO: \n");
        
        Consola.escribir("sucursal: " + "Sucursal B");
        double[] porcentaje = f.porcInstrumentosPorTipo("SuCuRsAl B");
        Consola.escribir("El porcentaje de instrumentos de sucursal es: ");
        for (int i = 0; i < porcentaje.length; i++) {
        Consola.escribir(porcentaje[i]);
        }
        
        
    }

    public static void cargarFabrica(Fabrica f) {
        Sucursal s1 = new Sucursal("Sucursal A");
        Sucursal s2 = new Sucursal("Sucursal B");

        s1.agregarInstrumento(new Instrumento("Flauta", 1450.5, TipoInstrumento.VIENTO));
        s1.agregarInstrumento(new Instrumento("Violin", 30500.5, TipoInstrumento.CUERDA));
        s1.agregarInstrumento(new Instrumento("Bombo", 5000.2, TipoInstrumento.PERCUSION));

        s2.agregarInstrumento(new Instrumento("Clarinete", 6450.5, TipoInstrumento.VIENTO));
        s2.agregarInstrumento(new Instrumento("Guitarra", 13500.5, TipoInstrumento.CUERDA));
        s2.agregarInstrumento(new Instrumento("Tambor", 45000.2, TipoInstrumento.PERCUSION));

//        s1.listarInstrumentos();
//        s2.listarInstrumentos();
        f.agregarSucursal(s1);
        f.agregarSucursal(s2);
    }

}
