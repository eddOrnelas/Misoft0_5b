/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package corte;

import reportes.ModeloCorte;
import venta.Venta;

/**
 *
 * @author Administrator
 */
public class ControlCorte {

    public ModeloCorte realizarCorte(String fecha1, String fecha2) {

        //Iniciamos objetos necesarios para la busqueda.
        Venta mVentas = new Venta(true);
        Object[] ventas = null;
        ModeloCorte corteCaja = new ModeloCorte();
        //Parametros de busqueda.
        Object[][] opciones = new Object[][]{{"fecha", ">=", fecha1}, {"fecha", "<=", fecha2}};

        ventas = mVentas.buscarBD("all", opciones);

        Integer tmpNumVentas = 0;
        //String tmpIdUsuario;
        Float tmpTotal = 0F;
        //Float tmpEfectivo=0F;
        Float tmpCorte;

        Float tmpIngresos = 0F;
        Float tmpRetiros = 0F;

        int x = 0;

        if (ventas.length <= 0) {
            return null;
        } else {
            for (x = 0; x < ventas.length; x++) {

                tmpTotal += ((Venta) ventas[x]).getTotal();
              //  tmpIngresos += ((Venta) ventas[x]).getIngresos();
              //  tmpRetiros += ((Venta) ventas[x]).getRetiros();
                tmpNumVentas++;

            }
            
            tmpCorte = tmpTotal+tmpIngresos-tmpRetiros;
            corteCaja.setCorte(tmpCorte);
            corteCaja.setNumVentas(tmpNumVentas);
            corteCaja.setTotal(tmpTotal);
            corteCaja.setIngresos(tmpIngresos);
            corteCaja.setRetiros(tmpRetiros);

        }
        return corteCaja;
    }
}
