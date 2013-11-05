/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package articulo;


import java.util.logging.Level;
import java.util.logging.Logger;
import misoft.CustomORM;

/**
 *
 * @author Eddie
 */
public class Articulo extends CustomORM {
    
   
    private Long idArticulo;
    private Long codigoArticulo;
    private String descripcion;
    private Float precioCompra;
    private Float precioVenta;
    private Integer cantidadExistencia;
    private String proveedor;
    private Boolean activo;

  

    
    
    public Articulo()
    {
        
    }

    public Articulo(Boolean init)
    {
        super();
        useTable = "articulo";
        keyField = "idArticulo";
        this.init(this);
    }

   
    
    

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(Long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    
    

    public Integer getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(Integer cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

   
    
    
}
