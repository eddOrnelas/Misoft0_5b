/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package venta;

import misoft.CustomORM;

/**
 *
 * @author DANY
 */
public class Venta extends CustomORM {
     // private Long idArticuloVenta;
//   private Long idArticulo;
    //private Long idDetalleVenta;
    private Long idVenta;
    private Integer cantidad;
    private String fecha;
   // private String hora;
   // private Float precio;
   
   private Float total;

public Venta() {
        //throw new UnsupportedOperationException("Not yet implemented");
    }
public Venta(Boolean init)
    {
        super();
        useTable = "venta";
        keyField = "idVenta";
        this.init(this);
    }

    


    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

//    public String getHora() {
//        return hora;
//    }
//
//    public void setHora(String hora) {
//        this.hora = hora;
//    }


      public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "[idVenta"+this.getIdVenta()+" fecha: "+this.getFecha()+"[cantidad"+this.getCantidad()+"total:"+this.getTotal();
    }
    
}
