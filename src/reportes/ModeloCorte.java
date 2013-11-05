/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import misoft.CustomORM;

/**
 *
 * @author Administrator
 */
public class ModeloCorte extends CustomORM {

    private String fecha1;
    private String fecha2;
    private Integer idVenta;
    //private String idUsuario;
    private Long idArticulo;
    private String descripcion;
    private Integer cantidad;
    private Float iva;
    private Float subTotal;
    private Float total;
    //private Float devolucion;
    private String fecha;
    private Float ingresos;
    private Float retiros;
    private Integer numVentas;
    private Float corte;

    public ModeloCorte() {
    }

    public ModeloCorte(Boolean init) {
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    /*
     public String getIdUsuario() {
     return idUsuario;
     }

     public void setIdUsuario(String idUsuario) {
     this.idUsuario = idUsuario;
     }
     */

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    /*
     public Float getEfectivo() {
     return efectivo;
     }

     public void setEfectivo(Float efectivo) {
     this.efectivo = efectivo;
     }

     public Float getDevolucion() {
     return devolucion;
     }

     public void setDevolucion(Float devolucion) {
     this.devolucion = devolucion;
     }
     */

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getIngresos() {
        return ingresos;
    }

    public void setIngresos(Float ingresos) {
        this.ingresos = ingresos;
    }

    public Float getRetiros() {
        return retiros;
    }

    public void setRetiros(Float retiros) {
        this.retiros = retiros;
    }

    public Integer getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(Integer numVentas) {
        this.numVentas = numVentas;
    }

    public Float getCorte() {
        return corte;
    }

    public void setCorte(Float corte) {
        this.corte = corte;
    }
}
