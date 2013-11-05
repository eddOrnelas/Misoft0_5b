/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package articulo;

import java.util.Date;
import misoft.CustomORM;

/**
 *
 * @author Eddie
 */
public class HistorialAlmacen extends CustomORM{
    
    private Long idHistorialAlmacen;
    private Long idArticulo;
    private String concepto;
    private Integer cantidad;
    private String fecha;
    private String extra;
    private Float precioCompra;
    private Float precioVenta;
    

    
    
    public HistorialAlmacen()
    {
        
    }
    
    public HistorialAlmacen(Boolean init)
    {
        super();
        useTable = "historialalmacen";
        keyField = "idHistorialAlmacen";
        this.init(this);
    }
    
    
    public Long getIdHistorialAlmacen() {
        return idHistorialAlmacen;
    }

    public void setIdHistorialAlmacen(Long idHistorialAlmacen) {
        this.idHistorialAlmacen = idHistorialAlmacen;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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

    public void setFecha(String fechaHora) {
        this.fecha = fechaHora;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
    
}
