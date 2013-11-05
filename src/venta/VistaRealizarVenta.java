/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package venta;
import com.sun.org.apache.bcel.internal.generic.Select;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import articulo.Articulo;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import articulo.Articulo;
import articulo.ControlArticulo;


  

  

/**
 *
 * @author DANY
 */
public class VistaRealizarVenta extends javax.swing.JPanel {
 private int selection;
int posicion=0;
//int contadorProductos=0;
ControlVenta ctrVenta=new ControlVenta();
ArticuloVenta venta=new ArticuloVenta();
Articulo tempArticulo=new Articulo();
/// para mostrar la fecha y la hora

 Calendar calendario = Calendar.getInstance();
 Calendar Cal = new GregorianCalendar();
 
        
 int hora;
 ArrayList tempCarrito=null;
   Integer generaridVenta=1;
  //   Validar validar=new Validar();
    double acumIva;
    double  iva=.11;
    Integer cantidadArticulos=0;
    //Object[] articulos;
String fecha;
String hor;
    /*    
 * 

     * Creates new form panelVenta
     */
    public VistaRealizarVenta() {
        initComponents();
     // hora =calendario.get(Calendar.HOUR);
      // Calendar Cal= Calendar.getInstance();
fecha= Cal.get(Calendar.DATE)+"/"+(Cal.get(Calendar.MONTH)+1)+"/"+Cal.get(Calendar.YEAR)+" \n";
hor= Cal.get(Calendar.HOUR_OF_DAY)+":"+Cal.get(Calendar.MINUTE);
generaridVenta=1;
lbTitulo.setText("Venta del dia  "+fecha+" -- Venta  #"+generaridVenta);
acumIva=0;
//VistaAgregarArticulosVarios vistaAgregarArticulosVarios=new VistaAgregarArticulosVarios();


    }

    /**
    
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        etTotal = new javax.swing.JLabel();
        etPagoCon = new javax.swing.JLabel();
        etCambio = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();
        txPagoCon = new javax.swing.JTextField();
        txCambio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txSubtotal = new javax.swing.JTextField();
        btCobrarVenta = new javax.swing.JButton();
        lbBarraEstado = new javax.swing.JLabel();
        txAgregarArticulo = new javax.swing.JTextField();
        btAgregarArticulo = new javax.swing.JButton();
        btEliminarArticulo = new javax.swing.JButton();
        btEliminarVenta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btBuscarArticulo = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txCantidad = new javax.swing.JTextField();
        javax.swing.JButton txConsultarVentas = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1480, 590));
        setLayout(null);

        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Descripcion", "PrecioPorUnidad", "Cantidad", "IVA", "subtotal", "total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbVenta);

        add(jScrollPane1);
        jScrollPane1.setBounds(150, 200, 840, 270);

        etTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etTotal.setText("Total:");
        add(etTotal);
        etTotal.setBounds(1010, 200, 120, 40);

        etPagoCon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etPagoCon.setText("Pago con:");
        add(etPagoCon);
        etPagoCon.setBounds(1010, 250, 180, 40);

        etCambio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etCambio.setText("Cambio:");
        add(etCambio);
        etCambio.setBounds(1010, 300, 90, 30);

        txTotal.setText("0.0");
        txTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalActionPerformed(evt);
            }
        });
        add(txTotal);
        txTotal.setBounds(1120, 210, 120, 30);

        txPagoCon.setText("0.0");
        txPagoCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiarPagoCon(evt);
            }
        });
        add(txPagoCon);
        txPagoCon.setBounds(1120, 260, 120, 30);

        txCambio.setText("0.0");
        add(txCambio);
        txCambio.setBounds(1120, 300, 120, 30);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Subtotal:");
        add(jLabel1);
        jLabel1.setBounds(1010, 160, 90, 20);

        txSubtotal.setEditable(false);
        txSubtotal.setBackground(new java.awt.Color(204, 204, 204));
        txSubtotal.setText("0.0");
        add(txSubtotal);
        txSubtotal.setBounds(1120, 160, 120, 30);

        btCobrarVenta.setText("Cobrar");
        btCobrarVenta.setPreferredSize(new java.awt.Dimension(140, 40));
        btCobrarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cobrarVenta(evt);
            }
        });
        add(btCobrarVenta);
        btCobrarVenta.setBounds(1010, 350, 230, 40);

        lbBarraEstado.setBackground(new java.awt.Color(51, 204, 255));
        lbBarraEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbBarraEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBarraEstado.setText("Barra de estado");
        lbBarraEstado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(lbBarraEstado);
        lbBarraEstado.setBounds(150, 520, 930, 15);

        txAgregarArticulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");
        txAgregarArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiartxAgregarArticulo(evt);
            }
        });
        txAgregarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txAgregarArticuloActionPerformed(evt);
            }
        });
        add(txAgregarArticulo);
        txAgregarArticulo.setBounds(300, 160, 360, 30);

        btAgregarArticulo.setText("AgregarArticulo");
        btAgregarArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgregarArticuloVenta(evt);
            }
        });
        add(btAgregarArticulo);
        btAgregarArticulo.setBounds(850, 150, 140, 40);

        btEliminarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img20x20/cancelar_1.jpg"))); // NOI18N
        btEliminarArticulo.setText("Eiminar Articulo");
        btEliminarArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEliminarArticulo(evt);
            }
        });
        add(btEliminarArticulo);
        btEliminarArticulo.setBounds(140, 70, 140, 40);

        btEliminarVenta.setText("EliminarVenta");
        btEliminarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarVenta(evt);
            }
        });
        add(btEliminarVenta);
        btEliminarVenta.setBounds(410, 70, 130, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Codigo del Articulo:");
        add(jLabel2);
        jLabel2.setBounds(150, 160, 150, 30);

        btBuscarArticulo.setText("BuscarArticulo");
        btBuscarArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBuscarArticulo(evt);
            }
        });
        add(btBuscarArticulo);
        btBuscarArticulo.setBounds(280, 70, 130, 40);

        lbTitulo.setBackground(new java.awt.Color(51, 255, 51));
        lbTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTitulo.setText("Venta del dia:");
        add(lbTitulo);
        lbTitulo.setBounds(150, 120, 460, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo/bannerVentas.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1370, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        add(jLabel4);
        jLabel4.setBounds(670, 170, 70, 17);

        txCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCantidad.setText("1");
        txCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiarCantidad(evt);
            }
        });
        add(txCantidad);
        txCantidad.setBounds(740, 160, 90, 30);

        txConsultarVentas.setText("Consultar Ventas");
        txConsultarVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConsultarVentas(evt);
            }
        });
        add(txConsultarVentas);
        txConsultarVentas.setBounds(540, 70, 140, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void txTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txTotalActionPerformed

    private void cobrarVenta(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cobrarVenta
    boolean existe=false;
      Integer status=0;
    Float temPago;
    Float pagoCon = null;
     String codigo = txAgregarArticulo.getText();
     
          String cantidadArticulo=txCantidad.getText();
     
        System.out.println("generarIdVenta se suma"+ generaridVenta);
     // ctrVenta.realizarRegistroVenta( tempCarrito,generaridVenta);
      
      //try{
          
         pagoCon=Float.parseFloat(txPagoCon.getText());
         
//         if(pagoCon!=null){
         //float pagoConRedondeado=ctrVenta.redondear(pagoCon);
        System.out.println("pagoCon:"+pagoCon);
   
       
   existe=ctrVenta.validarNumerosNegativos(pagoCon);
         if(existe){
                JOptionPane.showMessageDialog(this, "Datos incorrectos,NUMEROS NEGATIVOSS-favor de ingresar de nuevo el pago");
         txPagoCon.setText("0.0");
         }
        else {
             if(pagoCon==0||pagoCon==null){
                JOptionPane.showMessageDialog(this, "Datos incorrectos,-favor de ingresar de nuevo el pago");
txPagoCon.setText("0.0");
             }
             //else{   
                 
                 
          
Float  totalSubtotales=ctrVenta.recuperarSumaSubtotales();
         
Float totalVenta=ctrVenta.recuperarSumaTotalVenta();
 float ResultadoVenta=ctrVenta.calcularVenta(totalVenta,pagoCon);
        float resultadoVenta=ctrVenta.redondear(ResultadoVenta);
boolean existeTotal=ctrVenta.validarCantidadPago(pagoCon,resultadoVenta);        
                 System.out.println("existeTotal:"+existeTotal);
                 boolean existeNegativosTotal=ctrVenta.validarNumerosNegativos(resultadoVenta);
             System.out.println("existeNegativosTotal:"+existeNegativosTotal);

              if(existeTotal==true){
               JOptionPane.showMessageDialog(this, "Datos incorrectos,total cantidad mennor-favor de ingresar de nuevo el pago");
  txSubtotal.setText(Float.toString(totalSubtotales));
          txTotal.setText(Float.toString(totalVenta));
              }  
              else{
                  if(existeNegativosTotal==true){
    JOptionPane.showMessageDialog(this, "Datos incorrectos -favor de ingresar de nuevo el pago");
  txSubtotal.setText(Float.toString(totalSubtotales));
          txTotal.setText(Float.toString(totalVenta));
              }
                  else{
                
                
                  status= ctrVenta.registrarVenta(tempCarrito,cantidadArticulos, totalVenta);
                      if(status==1)
           {
               ctrVenta.realizarRegistroDeArticulos(ctrVenta.idventaGenerada, tempCarrito,cantidadArticulos,totalVenta);
               

               JOptionPane.showMessageDialog(this,"Datos correctos-venta Exitosa");
           }
                      else{
               JOptionPane.showMessageDialog(this,"Datos incorrectos-");
 
                      }
                      
           //barraEstado.setText("Alta Articulos: Completado");
           

        txCambio.setText(Float.toString((resultadoVenta)));
        lbBarraEstado.setText("Venta Exitosa");
          //lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
               txSubtotal.setText("0.0");

             txCantidad.setText("1");
              txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");
               
        generaridVenta++;
      lbTitulo.setText("Venta del dia  "+fecha+" -- Venta  #"+generaridVenta);

       txSubtotal.setText("0.0");
       txTotal.setText("0.0");
       txPagoCon.setText("0.0");
 
   borrartabla();
   ctrVenta.eliminarVentaActual();
                  
                  
                  }
              }
 
        
             
             }
         
         
 
  
//          }catch(  NumberFormatException | NullPointerException e){
//     JOptionPane.showMessageDialog(this,"Datos Incorrectos n.n -Favor de Ingresar Pago");
//                        txPagoCon.setText("0.0");           }
             //try{      
  //ctrVenta.realizarRegistroVenta( tempCarrito,generaridVenta);
//             }catch(IndexOutOfBoundsException e){
//                  JOptionPane.showMessageDialog(this,"IndexOutOfBoundsException e");
//
//             }
    
    }//GEN-LAST:event_cobrarVenta

    private void txAgregarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txAgregarArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txAgregarArticuloActionPerformed

    private void AgregarArticuloVenta(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarArticuloVenta
        // TODO add your handling code here:
         txCambio.setText("0.0");
         
boolean existeCodigo=false,existe2=false,existeCantidad=false;boolean existetotal=false;
Float temPago;String codigo="";String cantidadArticulo="";Integer cantidad=0;
float totalVenta = 0;

         float totalSubtotales = 0;
         cantidadArticulo=txCantidad.getText();
         codigo = txAgregarArticulo.getText();
         
        existeCodigo=ctrVenta.validarCamposVacios(codigo);
        existeCantidad=ctrVenta.validarCamposVacios(cantidadArticulo);
        
          try
        {
          cantidad =   Integer.parseInt(cantidadArticulo);
        }catch(NumberFormatException e)
        {
        
        }
        
             if(existeCodigo==true||
                     "".equals(codigo)){
            
              JOptionPane.showMessageDialog(this,"Datos Incorrectos, campo vacio-Favor de agregar Articulo");
           txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");// limpia la caja de texto

              lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
               //txSubtotal.setText("0.0");

          txCantidad.setText("1");
            txSubtotal.setText(Float.toString(totalSubtotales));
          txTotal.setText(Float.toString(totalVenta));
             
}
             else{
                 
                existeCantidad=ctrVenta.validarNumerosNegativos(cantidad);
                if(existeCantidad){
             JOptionPane.showMessageDialog(this,"Datos Incorrectos, numeros negativos-Favor de agregar cantidad");
              lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
               txSubtotal.setText("0.0");
//          txTotal.setText("0.0");
//          txCambio.setText("0.0");
             txCantidad.setText("1");
                txSubtotal.setText(Float.toString(totalSubtotales));
          txTotal.setText(Float.toString(totalVenta));
                }
                else{
                          if(existeCodigo==true&&existeCantidad==true){
                    txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");// limpia la caja de texto
         txCantidad.setText("1");
            txSubtotal.setText(Float.toString(totalSubtotales));
          txTotal.setText(Float.toString(totalVenta));
                         JOptionPane.showMessageDialog(this, "datos incorrectos,numerosNegativos");

                }
                          else{
        //Long donde almacenamos el codigo de articulo
        Long codigoArticulo =null;
        //Iniciamos controladoric
        ControlArticulo ctrArticulo = new ControlArticulo();
        //Iniciamos objectos donde guardaremos los resultados de busqueda
Object[] articulos = null;
        
        
        //Conversion a long
        try
        {
          codigoArticulo =   Long.parseLong(codigo);
        }catch(NumberFormatException e)
        {
        
        }
        
        if(codigoArticulo!=null) {
            articulos =  ctrArticulo.buscarPorCodigoArticulo(codigoArticulo);
            Boolean agregarArticulo = ctrVenta.agregarArticulo(codigoArticulo,cantidad);

                 
        }
       
        else {
            
 
   
            articulos = ctrArticulo.buscarPorDescripcion(codigo);
                     Long cod;
                     cod = ctrVenta.buscarCodigoDescripcion( articulos,codigo);
                     System.out.println("cod:"+cod);
                      Boolean agregarArticulo = ctrVenta.agregarArticulo(cod,cantidad);
 
       }
        
            
        
        if(articulos.length<=0||articulos==null)
        {  JOptionPane.showMessageDialog(this,"Datos Incorrectos,no se encontro articulo ");
        txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");
         lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
         txCantidad.setText("1");
         cantidadArticulos=0;
        }
        else
        {cantidadArticulos++;
                    
          System.out.println("---------------------------------");
         //System.out.println("acumIvaArticulo:"+acumIva);
         try {//llenarTabla(ctrVenta.recuperarIvaTotalArticulo());
              llenarTabla(ctrVenta.recuperarCarrito());
            // llenarTabla(ctrVenta.recuperarIvaTotalArticulo());
            } catch (SQLException ex) {
                Logger.getLogger(VistaRealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
     
            
   
         float subtotales=ctrVenta.sumarSubtotales(ctrVenta.recuperarCarrito());  
        float total= ctrVenta.sumarTotalesVenta(ctrVenta.recuperarCarrito());
         totalVenta= ctrVenta.redondear(total);
         totalSubtotales=ctrVenta.redondear(subtotales);
         
         //Float  totalSubtotales=ctrVenta.recuperarSumaSubtotales();
       
         //Float totalVenta=ctrVenta.recuperarSumaTotalVenta();
        // Validar validarCampos=new Validar();
         existetotal=ctrVenta.validarNumerosNegativos(totalVenta);
         if(existetotal){
                JOptionPane.showMessageDialog(this, "datos incorrectos,favor de volver ingresar de nuevo el pago");
                txPagoCon.setText("0.0");
                System.out.println("existeTOTAL:"+existetotal);
         
         }
         else{
             // existetotal=validarCampos.validarCantidadPago(total, totalVenta);
          txSubtotal.setText(Float.toString(totalSubtotales));
          txTotal.setText(Float.toString(totalVenta));
        txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");// limpia la caja de texto
         txCantidad.setText("1");
          lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
         }
        }
                     //} }
                          }//segundo if fin
          
             }
             }//primer if fin
        //fin de agregarArticulo a la venta  
    }//GEN-LAST:event_AgregarArticuloVenta

    private void btEliminarArticulo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEliminarArticulo
        // TODO add your handling code here:

    cantidadArticulos--;
        Object opciones[] = { "SI", "NO" };
     Integer seleccion = JOptionPane.showOptionDialog(this, "Deceas eliminar el articulo seleccionado?", "Atencion!",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);
     if(seleccion == JOptionPane.YES_OPTION)
            {
       eliminarArticulodelaVenta();// de la tabla articulo
              //lbBarraEstado.setText("Se elimino el Articulo de la venta");
            }
 
            //poner un jopcionPane para confirmar          

       
    }//GEN-LAST:event_btEliminarArticulo

    private void cancelarVenta(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarVenta
        // TODO add your handling code here:
              Object opciones[] = { "SI", "NO" };cantidadArticulos=0;
     Integer seleccion = JOptionPane.showOptionDialog(this, "Deceas eliminar la venta?", "Atencion!",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);
     if(seleccion == JOptionPane.YES_OPTION)
            {
       
        if(generaridVenta==1){
        generaridVenta=1;
        lbTitulo.setText("Venta del dia  "+fecha+" -- Venta  #"+generaridVenta);
        txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");
          lbBarraEstado.setText("Se Cancelo la venta");
           lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
        }
        else{
        generaridVenta--;
        lbTitulo.setText("Venta del dia  "+fecha+" -- Venta  #"+generaridVenta);
        lbBarraEstado.setText("Se Cancelo la venta");
         lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
        }
        borrartabla();
       ctrVenta.eliminarVentaActual();       
        txSubtotal.setText("0.0");
          txTotal.setText("0.0");
          txPagoCon.setText("0.0");
          txCambio.setText("0.0");
          txCantidad.setText("1");
          txAgregarArticulo.setText("Teclee o Agrege Código de Barras del Articulo");
          lbBarraEstado.setText("Se Cancelo la venta");
           lbBarraEstado.setText("Teclee o Agrege Código de Barras del Articulo");
            }
          
    }//GEN-LAST:event_cancelarVenta

    private void btBuscarArticulo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuscarArticulo
        // TODO add your handling code here:
          VistaBuscarArticulo vistaBuscarArticulo=new VistaBuscarArticulo();
        vistaBuscarArticulo.show();
    }//GEN-LAST:event_btBuscarArticulo

    private void limpiartxAgregarArticulo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiartxAgregarArticulo
        // TODO add your handling code here:
        
        txAgregarArticulo.setText("");
    }//GEN-LAST:event_limpiartxAgregarArticulo

    private void limpiarPagoCon(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarPagoCon

        // TODO add your handling code here:
        txPagoCon.setText("");
        //txCantidad.setText("");
    }//GEN-LAST:event_limpiarPagoCon

    private void limpiarCantidad(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarCantidad
        // TODO add your handling code here:
             txCantidad.setText("");
    }//GEN-LAST:event_limpiarCantidad

    private void ConsultarVentas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultarVentas
        // TODO add your handling code here:
          VistaConsultarVentas vistaConsultar=new VistaConsultarVentas();
        vistaConsultar.show();
    }//GEN-LAST:event_ConsultarVentas

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarArticulo;
    private javax.swing.JButton btBuscarArticulo;
    private javax.swing.JButton btCobrarVenta;
    private javax.swing.JButton btEliminarArticulo;
    private javax.swing.JButton btEliminarVenta;
    private javax.swing.JLabel etCambio;
    private javax.swing.JLabel etPagoCon;
    private javax.swing.JLabel etTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBarraEstado;
    private javax.swing.JLabel lbTitulo;
    public javax.swing.JTable tbVenta;
    public javax.swing.JTextField txAgregarArticulo;
    public javax.swing.JTextField txCambio;
    private javax.swing.JTextField txCantidad;
    public javax.swing.JTextField txPagoCon;
    public javax.swing.JTextField txSubtotal;
    public javax.swing.JTextField txTotal;
    // End of variables declaration//GEN-END:variables
   
        
 public Object llenarTabla(ArrayList carrito2) throws SQLException
    {double ivat=0,ivaTotal=0;
       DefaultTableModel datos = (DefaultTableModel) tbVenta.getModel();
       ControlArticulo ctrArticulo = new ControlArticulo();
       Articulo articulo = new Articulo();
        Integer nArticulos = carrito2.size();
//       if(nArticulos!=0){
       datos.setRowCount(0);     // }
       //else{
//            if(nArticulos==0){
//JOptionPane.showMessageDialog(this, "NO HAY ARTICULOS EN EL CARRITO");
//
//            }
//            else{
      for(Object thisArticulo: carrito2)//for para recorrer el array 
      {
       Integer cantidad = (Integer)((Object[])thisArticulo)[1];//cantidad
       Long idArticulo = (Long)((Object[])thisArticulo)[0];//se convierte de un objeto a una variable de tipo long
 // double ivap=(double)((Object[])thisArticulo)[2];
       articulo = ctrArticulo.buscarUnoPorCodigoArticulo(idArticulo);//se hace una busqueda
            Long tempidArticulo=idArticulo;
            Float total;//se envian las variables 
            total = ctrVenta.calcularTotal(articulo.getPrecioVenta(),cantidad);
                           venta.setTotal(total);
                         
            Float subtotal=ctrVenta.calcularSubTotal(articulo.getPrecioVenta(), cantidad);//se calcula el total de la venta por articulo
                           venta.setSubTotal(subtotal);
                 
     if((articulo.getCodigoArticulo().equals(idArticulo))&&cantidad==1){
         ivat=ctrVenta.calcularIva(iva,articulo.getPrecioVenta());
         acumIva=0;
        double tempIva=ivat*cantidad;
         acumIva+=tempIva;
          System.out.println("idArticulo:"+idArticulo);
                  System.out.println("CodigoArticulo:"+articulo.getCodigoArticulo()); 
                  System.out.println("precioVenta:"+articulo.getPrecioVenta());
                  System.out.println("acumIva:"+acumIva);
                  System.out.println("-------------------------------------------");
       
     venta.setIva(ctrVenta.redondearIva(acumIva));
     
     }
     else
     {acumIva=0;
         
                  
            ivat=ctrVenta.calcularIva(iva,articulo.getPrecioVenta());
            double tempIva=ivat*cantidad;
     acumIva+=tempIva;
       System.out.println("idArticulo:"+idArticulo);
                  System.out.println("CodigoArticulo:"+articulo.getCodigoArticulo()); 
                  System.out.println("precioVenta:"+articulo.getPrecioVenta());
      System.out.println("acumIva:"+acumIva);
       System.out.println("-------------------------------------------");
     venta.setIva(ctrVenta.redondearIva(acumIva));
     }  //agrega una fila cada vez que encuentra registros.
     
        datos.addRow(new Object[] {
              idArticulo,
              articulo.getDescripcion(),
              articulo.getPrecioVenta(), 
              cantidad,
             venta.getIva(),
             venta.getSubtotal(), 
              venta.getTotal()
                 
        });
         RowSorter<TableModel> sorter;
        sorter = new TableRowSorter<>(tbVenta.getModel());

        tbVenta.setRowSorter(sorter);
        tempCarrito=carrito2;
          
       }//fin del for     }
    return carrito2;
       
    }
 private void borrarArticuloTabla(int aeliminar){
//Articulo articulo=new Articulo();
 ControlArticulo ctrArticulo=new ControlArticulo();
    Integer nArticulos= tempCarrito.size();
        System.out.println("a eliminar:"+aeliminar);
        for (int i = 0; i <nArticulos; i++)
     {   if(aeliminar==i){
                
            Object[] articulo = (Object[]) tempCarrito.get(i);
            Long idArticulo = (Long)articulo[0];
                 System.out.println("idArticulo-----:"+idArticulo);
                 float totalVenta=ctrVenta.restarArticuloTotalesVenta(idArticulo, tempCarrito);
                 float totalSubtotales=ctrVenta.restarSubtotalArticulo(idArticulo, tempCarrito);
                 //ctrVenta.eliminarArticulo(idArticulo, 1);
                 System.out.println("------------------------------------");
        System.out.println("totalSubtotales:"+totalSubtotales);
        System.out.println("totalVenta:"+totalVenta);
          txSubtotal.setText("");
          txTotal.setText("");
        txSubtotal.setText(Float.toString(totalSubtotales));
          txTotal.setText(Float.toString(totalVenta));
         tempCarrito.remove(i);
          // lbBarraEstado.setText("Se Cancelo la venta");
      
          lbBarraEstado.setText("Se elimino el Articulo de la venta");          
                
     }
  

      }
  
         
    }
 private void borrartabla(){
///Le asigno un DefaultTableModel a mi jTable para poderlo manipular mas facil

       DefaultTableModel dt = (DefaultTableModel) tbVenta.getModel();
       
for (int i = dt.getRowCount() -1; i >= 0; i--)
     {
            dt.removeRow(i);
      }
   dt.setRowCount(0);
   
   
        
    }
private void eliminarArticulodelaVenta(){
///Le asigno un DefaultTableModel a mi jTable para poderlo manipular mas facil

  try{ 

          
        
        DefaultTableModel dt=new DefaultTableModel();
        System.out.println("dt:"+dt.getRowCount());
         dt=(DefaultTableModel)tbVenta.getModel();
     System.out.println("numero en el vector:"+tbVenta.getSelectedRow());
   
     borrarArticuloTabla(tbVenta.getSelectedRow());
  
       dt.removeRow(tbVenta.getSelectedRow());
       // }
    }catch(Exception e){
  
        
              JOptionPane.showMessageDialog(null,"seleccione la fila  que se desea quitar");  
 
       }

 
 

}
}

