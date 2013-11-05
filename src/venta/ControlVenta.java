/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package venta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import articulo.Articulo;
import articulo.ControlArticulo;
import articulo.HistorialAlmacen;

/**
 *
 * @author isa
 */
public class ControlVenta {
    Calendar Cal = new GregorianCalendar();
   // private Iterable<Object> Codigo;
   private ArrayList carritoCompra;
   private ArrayList consultaventa;
   private ArrayList ivaTotalArticulo;
   private ArrayList ventaDetalle=new ArrayList();

    private int x=0;
    double iva=.11;
    float acumSubtotales=0;
    float acumTotales=0;
    float resTotales=0;
    float resSubtotales=0;
    double acumIva;
    public Long idventaGenerada;
         float ivaRes = 0,porcentaje=0;
                  //  HistorialAlmacen historial=new HistorialAlmacen();

//Articulo articulosBusca = new Articulo(true);
  ControlArticulo ctrArticulo=new ControlArticulo();

   ArticuloVenta ventar=new ArticuloVenta();
    Articulo articulo = new Articulo();
    ControlVenta(){
                 carritoCompra = new ArrayList();
                 consultaventa=new ArrayList();
                 ivaTotalArticulo=new ArrayList();
                 ventaDetalle=new ArrayList();
                  acumSubtotales=0;
                  acumTotales=0;
                  acumIva=0;
    }
      
    public Boolean agregarArticulo(Long idArticulo, Integer cantidad)
    { double totaliva=0;
       Integer nArticulos = carritoCompra.size();// para saber el tamaño del
       
        int x=0;
       for(x=0; x<nArticulos; x++)
       {
           Object[] articulo = (Object[]) carritoCompra.get(x);//se obtiene del arraylist[x] y se guarda en objeto
           
           if(articulo[0].equals(idArticulo))
           {//se compara si el articulo[0] es igual al id articulo
               Integer cantidadCarrito = (Integer)articulo[1];
               cantidadCarrito+=cantidad;//se agrega  a la canridad del carrito
             boolean exist=true;
             
             
//                totaliva=sumarTotalIva(iva,idArticulo);
             articulo[1] = cantidadCarrito;//se guarda la nueva cantidad en la posicion 1
               return true;
             
               //totaliva=sumarTotalIva(iva,idArticulo);
           }
          
           
           }
      
       
        carritoCompra.add(new Object[] {idArticulo,cantidad});//se crea un objeto con la nueva cantidad y el id articulo

        return true;
        
    }
   public void mostrarVentaTabla(Object [] articulosVenta ,int aeliminar){
//Articulo articulo=new Articulo();
// ControlArticulo ctrArticulo=new ControlArticulo();
    Integer nArticulos= articulosVenta.length;
        System.out.println("a eliminar:"+aeliminar);
        System.out.println("lenght:"+nArticulos);
        for (int i = 0; i <nArticulos; i++)
     {   
         if(aeliminar==i){
                
           Object[] articulo = (Object[]) articulosVenta[i];
           Long idArticulo = (Long)articulosVenta[i];//
                 
         //System.out.println("idArticulo-----:"+idArticulo);
                         System.out.println("idArticulo-----:"+articulosVenta.toString());

                
     }
     }}
    

    public ArrayList recuperarCarrito()
    {
        
        return carritoCompra;
        
    }
    
 
  Float calcularTotal(Float precioVenta, Integer cantidad){
//        System.out.println("precio:"+precioVenta);
//        System.out.println("cantidad:"+cantidad);
  
       
       porcentaje = (precioVenta*cantidad)*.11F;
       //System.out.println("porcentaje:"+porcentaje);
       ivaRes= (precioVenta*cantidad)+porcentaje;
      // System.out.println("ivaRes:"+ivaRes);
  
  return ivaRes;
   }//fin de calcularTotal
   
   float sumarSubtotales(ArrayList sumSubtotales){
   Float subtotal = null;//Integer cantidad=0;
  Integer nArticulo=sumSubtotales.size();
       //System.out.println("========Acumsubtotales:"+acumSubtotales);
      for(Object thisArticulo:sumSubtotales){
            Integer cantidad = (Integer)((Object[])thisArticulo)[1];//cantidad{
            Long idArticulo = (Long)((Object[])thisArticulo)[0];
           articulo = ctrArticulo.buscarUnoPorCodigoArticulo(idArticulo);//se hace una busqueda
        // cantidad+=cantidad;
           subtotal=calcularSubTotal(articulo.getPrecioVenta(),cantidad);
        // subtotal=calcularSubTotal(articulo.getPrecioVenta(),cantidad);//se calcula el total de la venta por articulo
             // ventar.setSubTotal(subtotal);
       
                    System.out.println("subtotalVenta:"+subtotal);
         // System.out.println("subtotalVenta:"+ventar.getSubtotal());
        }
 
           acumSubtotales+=subtotal;     
              
                System.out.println("SUUBTOTALES:"+acumSubtotales);
        return acumSubtotales;
        
 
   }
     float  recuperarSumaSubtotales(){
   
   return acumSubtotales;
   }
 
   
   Float calcularSubTotal(Float precioVenta,Integer cantidad){
   Float resTotal;
   resTotal=precioVenta*cantidad;
       return resTotal;
   }//fin
   
  float sumarTotalesVenta(ArrayList sumTotalVenta){
      Float total = null;//acumTotales=0;
     //Integer cantidad=0;
      System.out.println("acumTotales:"+acumTotales);
      Integer nArticulos=sumTotalVenta.size();
      for(Object thisArticulo: sumTotalVenta){
        
          Integer   cantidad = (Integer)((Object[])thisArticulo)[1];//cantidad{
           // Long idArticulo = (Long)((Object[])thisArticulo)[0];
             // cantidad+=cantidad;
            total=calcularTotal(articulo.getPrecioVenta(),cantidad);//se envian las variables 
                           ventar.setTotal(total);

                    System.out.println("totalVenta:"+total);
              
                   
      }
    

     
         acumTotales+=total;
           
              System.out.println("TOTALESvENNTA:"+acumTotales);
  return acumTotales;
        
  
  }
  float restarArticuloTotalesVenta(Long codigo,ArrayList sumTotalVenta){
      Float total = null,resta = null; //resTotales=0;
      //resTotales=acumTotales;
      System.out.println(sumTotalVenta);
      for(Object thisArticulo: sumTotalVenta){
          
           Integer cantidad = (Integer)((Object[])thisArticulo)[1];//cantidad{
          //System.out.println("cantidad:"+cantidad);
           Long idArticulo = (Long)((Object[])thisArticulo)[0];
          // System.out.println("codigo:"+codigo);
           articulo = ctrArticulo.buscarUnoPorCodigoArticulo(codigo);//se hace una busqueda
              if(idArticulo.equals(codigo)){
                         total=calcularTotal(articulo.getPrecioVenta(),cantidad);//se envian las variables 
 System.out.println("total:"+total);
              }
        }
           
 resTotales=acumTotales-total;  
float res=redondear(resTotales);
float acum=redondear(acumTotales);
      System.out.println("_____________________________");
System.out.println("ResTotales:"+res+"="+acum+"-"+total);
res=redondear(resTotales);
 acum=redondear(acumTotales);
acumTotales=resTotales;
 acum=res;

   
  return res;
  }
    float restarSubtotalArticulo(Long codigo,ArrayList sumSubtotales){
   Float subtotal = null; 
      for(Object thisArticulo:sumSubtotales ){
            Integer cantidad = (Integer)((Object[])thisArticulo)[1];//cantidad{
            Long idArticulo = (Long)((Object[])thisArticulo)[0];
           articulo = ctrArticulo.buscarUnoPorCodigoArticulo(idArticulo);//se hace una busqueda
           if(idArticulo.equals(codigo)){
                 
         subtotal=calcularSubTotal(articulo.getPrecioVenta(), cantidad);//se calcula el total de la venta por articulo
                            ventar.setSubTotal(subtotal);
       
                    System.out.println("subtotalVenta:"+subtotal);
           } }
                 resSubtotales=acumSubtotales-subtotal;
                 float res=redondear(resSubtotales);
                float acum=redondear(acumSubtotales);
                acumSubtotales=resSubtotales;
                acum=res;
        return res;
        
 
   }
  public  Float redondear(Float valor){
      //metodo para redondear float
 String val = valor+"";
 BigDecimal big = new BigDecimal(val);
 big = big.setScale(2, RoundingMode.HALF_UP);
 return Float.parseFloat(String.valueOf(big));
}
  
   Float recuperarSumaTotalVenta(){

        return acumTotales;
   } 
 
  
  //fin del metodo calcular iva
   public Double redondearIva(Double iva){
   return Math.rint(iva*100)/100;
   }
   boolean eliminarVentaActual(){
   //Object[] CarritoActual = (Object[]) carritoCompra.get(x);
  Integer nArticulos =carritoCompra.size();// para saber el tamaño del vector de objetos
           for(x=0; x<nArticulos; x++)
       {
         //  Object[] articulo = (Object[]) carrito.get(x);//se obtiene del arraylist[x] y se guarda en objeto
         carritoCompra.removeAll(carritoCompra);
      // carrito.remove(x);
           System.out.println("cuantos articulos tiene el carrito:"+carritoCompra.size());
          acumSubtotales=0;
      acumTotales=0;
           return true;
         
           //System.out.println(carrito);
           }//fin del for
      
        return false;
}
   
   public void realizarRegistroDeArticulos(Long idVenta,ArrayList carrito2,Integer cantidadArticulos,float totalVenta)
   {//Object[] carrito = (Object[]) carrito2.get(x);
       Long idArticulo=null;     float total=0;   

        Integer nArticulos =carrito2.size();// para saber el tamaño del vector de objetos
        for(Object thisArticulo: carrito2){
            Integer cantidad =
                    (Integer)((Object[])thisArticulo)[1];//cantidad{
            idArticulo = (Long)((Object[])thisArticulo)[0];
           articulo = ctrArticulo.buscarUnoPorCodigoArticulo(idArticulo);//se hace una busqueda
            //se envian las variables 
           total = calcularTotal(articulo.getPrecioVenta(),cantidad);
                           
           // ventar.setTotal(total);
        Float subtotal=calcularSubTotal(articulo.getPrecioVenta(), cantidad);//se calcula el total de la venta por articulo
                            //ventar.setSubTotal(subtotal);
        Double ivap=.11;
        iva=calcularIva(ivap,articulo.getPrecioVenta());
             
         ventar.setIva(redondearIva(iva));
          Float PrecioVenta=articulo.getPrecioVenta();
          String descripcion=articulo.getDescripcion();
         idArticulo=articulo.getIdArticulo();
            System.out.println("idArticulo:"+idArticulo);
            System.out.println("descripcion:"+descripcion);
            System.out.println("PrecioVenta:"+articulo.getPrecioVenta());
            System.out.println("cantidad:"+cantidad);
            System.out.println("iva:"+iva); 
            System.out.println("++++++++++total:"+total);
            System.out.println("sub-total:"+subtotal);
          
            System.out.println("idarticulo---------------:"+articulo.getIdArticulo());
       
            registrarVentaDeArticulos(idVenta,idArticulo,descripcion,PrecioVenta,cantidad,iva,total,subtotal,cantidadArticulos,totalVenta);
           

        }
  

    }
   public Venta buscarArticulo(Long idVenta)
   {
        Venta articulosBusqueda = new Venta(true);
        Object[] resultado = null;
        
        Object[][] opciones = new Object[][] {{"idVenta","=",idVenta}};
        
        resultado = articulosBusqueda.buscarBD("all", opciones);
        
        if(resultado.length<=0)
            return null;
        else
        {
            return (Venta)resultado[0];
        }
       
       
   }
   //busqueda venta 
  public Object[] buscarVentaPorFecha(String fecha) {
    //System.out.println("IMPRIME:"+fecha);
       Venta busca= new Venta(true);
    // Venta busca= new Venta(true);
        Object[] resultado = null;
        
        Object[][] opciones = new Object[][] {{"fecha","=",fecha}};
        
        resultado = busca.buscarBD("all", opciones);
        
        System.out.println("ok alpha");
    
      return resultado;
       
      }
  //////////////////////////////////////////////////////////////////////////////////////
     public Object[] buscarPorCodigoArticulo(Long codigoArticulo) {
    
        HistorialAlmacen articuloBusqueda = new HistorialAlmacen(true);
        Object[] resultado = null;
         System.out.println("codigoArticulo:"+codigoArticulo);
        Object[][] opciones = new Object[][] {{"idArticulo","=",codigoArticulo}};
        
        resultado = articuloBusqueda.buscarBD("all", opciones);
        
        return resultado;
    }
      public Object[] buscarPorDescripcion(String descripcion) {
        HistorialAlmacen articulosBusqueda = new HistorialAlmacen(true);
        Object[] resultado = null;
        
        Object[][] opciones = new Object[][] {{"concepto","=",descripcion}};
        
        resultado = articulosBusqueda.buscarBD("all", opciones);
        
        return resultado;
    }
    
     //////////////////////////////////////////////////////////////////////////////////////////////
  
   public   Long buscarCodigoDescripcion(Object[] buscaCodigo,String descripcion ){

  Long idArticulo=null;
  
    for(Object thisArticulo: buscaCodigo)
          {
           idArticulo = ((Articulo)thisArticulo).getCodigoArticulo();
         
             System.out.println("EL OBJETO:"+
             ((Articulo)thisArticulo).getCodigoArticulo()+
          ((Articulo)thisArticulo).getDescripcion()+
          ((Articulo)thisArticulo).getPrecioVenta()+
          ((Articulo)thisArticulo).getCantidadExistencia());
          }
    

   return idArticulo;
   }


   Object[] buscarTodasLasVentas() {
    
    ArticuloVenta venta= new ArticuloVenta(true);
    
    Object[] ventasTotales = venta.buscarBD("all",new Object[0][0]);
    
    
    
    return ventasTotales;
    
    }
   

   
   private void registrarVentaDeArticulos( Long idVenta, Long idArticulo,String descripcion, Float precioVenta, Integer cantidad, Double iva, Float total, Float subtotal,Integer cantidadArticulos,float totalVenta) {
       


       Integer statusOperation = null;
 
       ArticuloVenta Articuloventa = new ArticuloVenta(true);
        
     //  System.out.println("idB:"+ventar.getIdVenta());
     
           Articuloventa.setIdVenta(idVenta);
           Articuloventa.setIdArticulo(idArticulo);
        //   Articuloventa.setDescripcion(descripcion);
           Articuloventa.setCantidad(cantidad);
           Articuloventa.setPrecioVenta(precioVenta);
           Articuloventa.setIva(iva);
           Articuloventa.setTotal(total);
           Articuloventa.setSubTotal(subtotal);
  
           statusOperation = Articuloventa.registrarBD();
     //////////////////////////////////////////////////////////////////////////////
           
         Articulo articuloActualizado = new Articulo(true);
         
         articuloActualizado.setIdArticulo(idArticulo);
         articuloActualizado.buscarBD();
         
         articuloActualizado.setCantidadExistencia(articuloActualizado.getCantidadExistencia()-cantidad);
         articuloActualizado.acualizarBD();
           
     //////////////////////////////////////////////////////////////////////////////
               
           HistorialAlmacen historial=new HistorialAlmacen(true);
           historial.setConcepto("Venta");
           historial.setCantidad(-cantidad);
           historial.setIdArticulo(idArticulo);
           historial.setPrecioCompra(precioVenta);
           historial.setPrecioVenta(precioVenta);
           historial.registrarBD();
   }
Float calcularVenta(Float totalVenta,Float pagocon){
   Float cambio=null;
    cambio=pagocon-totalVenta;
    return cambio;
}
  

//////////////////////////////////////////////////////////////////////////////////////////////7
 
   public Integer eliminarArticulo(Long idArticulo, Integer cantidad)
    { 
       Integer nArticulos = carritoCompra.size();// para saber el tamaño del
   
        int x=0,h=0;
       for(x=0; x<nArticulos; x++)
       {
           Object[] articulo = (Object[]) carritoCompra.get(x);//se obtiene del arraylist[x] y se guarda en objeto
           
           if(articulo[0].equals(idArticulo))
           {//se compara si el articulo[0] es igual al id articulo
               h=x;
               Integer cantidadCarrito = (Integer)articulo[1];
               cantidadCarrito-=cantidad;//se decrementa  a la canridad del carrito
               articulo[1] = cantidadCarrito;//se guarda la nueva cantidad en la posicion 1
                  nArticulos--;
             
               return cantidadCarrito;
               
           }//fin del  if
          
           }//fin del for
       
         
     // nArticulos--;
        carritoCompra.add(new Object[] {idArticulo,cantidad});//se crea un objeto con la nueva cantidad y el id articulo

        return cantidad;
       }
  

   public  Double calcularIva(double ivaArticulo,Float precioVenta) {
    double ivap ;
    ivap=(ivaArticulo*precioVenta);
   
        return ivap;    
    }



 public Integer registrarVenta( ArrayList tempCarrito,Integer cantidadArticulos,float totalVenta){
        Integer statusOperation = null;
              // String hora= Cal.get(Calendar.HOUR_OF_DAY)+":"+Cal.get(Calendar.MINUTE);
               String fecha= Cal.get(Calendar.DATE)+"/"+(Cal.get(Calendar.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
           Venta venta=new Venta(true);

           venta.setCantidad(cantidadArticulos);
           venta.setFecha(fecha);
          // articuloVenta.setHora(hora);
           venta.setTotal(totalVenta);
             statusOperation = venta.registrarBD();
            
             statusOperation=1;

             if(statusOperation==1){
                 
                 this.idventaGenerada=venta.getIdVenta();
                 
             }
             else{
                 statusOperation=0;
             
             }
        return statusOperation;
 }

    Boolean  validarNumerosNegativos(Float numvalidar){
       System.out.println("numero a VALIDAR---------------------------:"+numvalidar);
   if(numvalidar<0){
return true;
   }
       return false; 
   }
    Boolean  validarNumerosNegativos(Integer numvalidar){
  
   if(numvalidar<0){
       System.out.println("es 0 la cantidad");
return true;
   }
       return false; 
   }
   Boolean validarCamposVacios(String campo){
   
       if(campo.trim().length()==0){
           System.out.println("campos vacios");
       return true;
   }
   return false;
   }
   Boolean validarCantidadPago(float pagoCon,float totalVenta){
       System.out.println("_________________________");
       System.out.println("pagoCon:"+pagoCon);
       System.out.println("totalVenta:"+totalVenta);
    if(pagoCon<=totalVenta){
        
    return true;
    }
       return false;
   }


}

