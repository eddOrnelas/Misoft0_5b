/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package venta;

import datechooser.beans.DateChooserDialog;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import articulo.Articulo;
import articulo.ControlArticulo;

/**
 *
 * @author chabe
 */
public class VistaConsultarVentas extends javax.swing.JFrame {
Calendar Cal = new GregorianCalendar();
ControlVenta ctrVenta=new ControlVenta();
ControlArticulo ctrArticulo=new ControlArticulo();
private ArrayList ventaDetalle=new ArrayList();
Long idVenta=null;
  Object[] articulos;
   private int selection;
    /**
     * Creates new form VistaConsultarVentas
     */
    public VistaConsultarVentas() {
        initComponents();
        //this.idVenta=idVenta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsultarVentaDia = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbReciboVenta = new javax.swing.JTable();
        javax.swing.JButton btConsultarFecha = new javax.swing.JButton();
        lbAtendio = new javax.swing.JLabel();
        lbnoVenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbFecha = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbConsultarVentaDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdVenta", "Fecha", "cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbConsultarVentaDia);
        tbConsultarVentaDia.getColumnModel().getColumn(2).setResizable(false);

        tbReciboVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo de Barras", "Descripcion", "Cantidad", "Total"
            }
        ));
        jScrollPane2.setViewportView(tbReciboVenta);

        btConsultarFecha.setText("Consultar Fecha");
        btConsultarFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConsultarVentas(evt);
            }
        });

        lbAtendio.setText("Le Atendio:");

        lbnoVenta.setText("No.Venta:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo/bannerConsultarVentas.png"))); // NOI18N

        jButton2.setText("Mostrar Recibo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarDetalles(evt);
            }
        });

        lbFecha.setText("Fecha:");

        calendario.setDateFormatString("yyyy-MM-dd");
        calendario.setMinSelectableDate(new java.util.Date(-62135765931000L));

        jButton1.setText("Devolucion del articulo seleccionado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btConsultarFecha)
                .addGap(18, 18, 18)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbAtendio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbnoVenta))
                    .addComponent(lbFecha, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAtendio)
                        .addGap(6, 6, 6)
                        .addComponent(lbnoVenta))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btConsultarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-966)/2, (screenSize.height-533)/2, 966, 533);
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarVentas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultarVentas
        // TODO add your handling code here:
          Object[] ventabusqueda=null;Long codigoArticulo=null;
   try {
           //String fecha=dcFecha.getText();
       //System.out.println("--------------fecha:"+fecha);
        //   String fecha=txFecha.getText();
           
           try{
                 //  codigoArticulo =   Long.parseLong(fecha);

           }catch(NumberFormatException e){}
         // SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
          // String fechaCal = = format1.format(calendario.get);
          String fechaCal = (calendario.getDate().getYear()+1900)+"-"+ (calendario.getDate().getMonth()+1)+"-"+calendario.getDate().getDate();
           //JOptionPane.showMessageDialog(this, fechaCal);
            
             boolean existe=ctrVenta.validarCamposVacios(fechaCal);
             if(existe){
             JOptionPane.showMessageDialog(this,"Datos Incorrectos-Favor de ingresar Fecha");
             }
             else{
//                 System.out.println("La fecha: "+fecha);
//                 System.out.println("ok0");
                 Venta tempVentas = new Venta(true);
                 Object[][] options= {{"fecha", ">=", fechaCal+" 00:00:00"},{"fecha", "<=", fechaCal+" 23:59:59"} };
//                 System.out.println("ok0.1");
            ventabusqueda= tempVentas.buscarBD("all", options);
//                 System.out.println("ok1 :"+ventabusqueda.length);
               //System.out.println("ventaBUSCA:"+ventabusqueda.toString());
            if(ventabusqueda.length<=0||ventabusqueda==null) {
                JOptionPane.showMessageDialog(this,"no se encontro venta");
          //  txFecha.setText("");
            }
            else
            {//ventabusqueda= ctrVenta.buscarVentaPorFecha(fecha);
               
            try {
                    //llenarTabla(ventabusqueda);
                      llenarTabla(ventabusqueda);
               // llenarTablaReciboVenta(ctrVenta.);
                    System.out.println("ok3");
                } catch (SQLException ex) {
                    Logger.getLogger(VistaConsultarVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }}
            //lbfechaSeleccionada.setText(fechaSeleccionada);

        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "null", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_ConsultarVentas

    private void mostrarDetalles(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarDetalles
           // TODO add your handling code here:
        selection= tbConsultarVentaDia.getSelectedRow();
      
       
        String errorLog = "";
        Long idVenta = null;
        Object[] articulos;
       ArticuloVenta busqueda = new ArticuloVenta(true);
    
        
        try{
        idVenta = (Long) tbConsultarVentaDia.getValueAt(selection, 0);
     
        }catch(java.lang.ArrayIndexOutOfBoundsException e)
        {
            
        }
        
        
        if(idVenta==null){
            errorLog +="Id de venta invalido \n";
        }
        else{
             Object[][] options = {{"idVenta", "=", idVenta}};
articulos = busqueda.buscarBD("all", options);

              llenarTablaReciboVenta(articulos);
        
  }
              
        
    }//GEN-LAST:event_mostrarDetalles

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultarVentas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser calendario;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAtendio;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbnoVenta;
    private javax.swing.JTable tbConsultarVentaDia;
    private javax.swing.JTable tbReciboVenta;
    // End of variables declaration//GEN-END:variables
private void llenarTabla(Object[] ventabusqueda) throws SQLException
    {
        //para hacer la consulta de las ventas del dia
     DefaultTableModel datos = (DefaultTableModel) tbConsultarVentaDia.getModel();
                    datos.setRowCount(0);
       for(Object thisVenta:ventabusqueda)
          {
          datos.addRow(new Object[]
          {
          
          ((Venta)thisVenta).getIdVenta(),
          ((Venta)thisVenta).getFecha(),
          ((Venta)thisVenta).getCantidad(),
          ((Venta)thisVenta).getTotal()
              
          }
                  );
          }

        RowSorter<TableModel> sorter;
        sorter = new TableRowSorter<>(tbConsultarVentaDia.getModel());
        tbConsultarVentaDia.setRowSorter(sorter);
       
       }//fin del for
private void llenarTablaReciboVenta(Object[] ventabusqueda)
    {Long idArticulo=null, idVentatitulo=null;
          //Articulo articulop=null;

        //para hacer la consulta de las ventas del dia
     DefaultTableModel datos = (DefaultTableModel) tbReciboVenta.getModel();
                    datos.setRowCount(0);
                                     

                  Articulo articulo=new Articulo();
                  Venta venta=new Venta();
String fechaEditada = null;
       for(Object thisArticuloVenta:ventabusqueda)
           {                Long id=((ArticuloVenta)thisArticuloVenta).getIdArticulo();
          
articulo=ctrArticulo.buscarUnoPorIdArticulo(id);
venta=ctrVenta.buscarArticulo(idVenta);
fechaEditada=venta.getFecha().split(" ")[0];
  //System.out.println("venta:"+venta.getFecha());
  idVentatitulo=((ArticuloVenta)thisArticuloVenta).getIdVenta();

          datos.addRow(new Object[]
          {

          
            articulo.getCodigoArticulo(),
            articulo.getDescripcion(),
             ((ArticuloVenta)thisArticuloVenta).getCantidad(),
             ((ArticuloVenta)thisArticuloVenta).getTotal(),


        
              
          }
                  );
          }
                     //idVenta=((ArticuloVenta)thisArticuloVenta).getIdVenta();
lbnoVenta.setText("No.Venta: "+idVentatitulo);
lbAtendio.setText("Le atendio: ");
lbFecha.setText("fecha:"+fechaEditada);
       

        RowSorter<TableModel> sorter;
        sorter = new TableRowSorter<>(tbConsultarVentaDia.getModel());
        tbConsultarVentaDia.setRowSorter(sorter);
       
       }//fin del for
   

 private void borrarTabla(){
//     /Le asigno un DefaultTableModel a mi jTable para poderlo manipular mas facil

     DefaultTableModel dt=new DefaultTableModel();
tbConsultarVentaDia.setModel(dt);
    
     for (int i = dt.getRowCount() -1; i >= 0; i--)
     {
            dt.removeRow(0);
      }
     
     
     
     //return null;
     

 }


 private void mostrarVentaTabla(int aeliminar){
//Articulo articulo=new Articulo();
// ControlArticulo ctrArticulo=new ControlArticulo();
    Integer nArticulos= articulos.length;
        System.out.println("a eliminar:"+aeliminar);
        for (int i = 0; i <nArticulos; i++)
     {   if(aeliminar==i){
                
           // Object[] articulo = (Object[]) articulos[i];
            Long idArticulo = (Long)articulos[i];
                 System.out.println("idArticulo-----:"+idArticulo);
               
     
         
          // lbBarraEstado.setText("Se Cancelo la venta");
      
          //lbBarraEstado.setText("Se elimino el Articulo de la venta");          
                
     }
  

      }
  
         
  }


}