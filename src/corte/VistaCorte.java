/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package corte;

import reportes.ModeloCorte;
import javax.swing.JOptionPane;
import java.util.Calendar;
import reportes.ControlReporte;

/**
 *
 * @author Administrator
 */
public class VistaCorte extends javax.swing.JPanel {

    /**
     * Creates new form VistaCorteCaja
     */
    private Integer fecha = null;

    public VistaCorte() {
        initComponents();
    }

    public VistaCorte(Integer idPrueba) {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNoVentas = new javax.swing.JTextField();
        txDineroVentas = new javax.swing.JTextField();
        txTotal = new javax.swing.JTextField();
        btCorte = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txFechaInicio = new com.toedter.calendar.JDateChooser();
        txFechaFinal = new com.toedter.calendar.JDateChooser();
        btReporte = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 29)); // NOI18N
        jLabel1.setText("Corte de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Numero de Ventas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Dinero Ventas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel4.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.05;
        add(txNoVentas, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.05;
        add(txDineroVentas, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.05;
        add(txTotal, gridBagConstraints);

        btCorte.setText("Aceptar");
        btCorte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarCorte(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.05;
        add(btCorte, gridBagConstraints);

        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.05;
        add(btCancelar, gridBagConstraints);

        btLimpiar.setText("Limpiar");
        btLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLimpiarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.5;
        add(btLimpiar, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Nombre del Cajero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.05;
        add(txUsuario, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setText("Encargado de turno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setText("Dinero en Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(jLabel9, gridBagConstraints);

        txFechaInicio.setDateFormatString("yyyy-MM-dd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(txFechaInicio, gridBagConstraints);

        txFechaFinal.setDateFormatString("yyyy-MM-dd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(txFechaFinal, gridBagConstraints);

        btReporte.setText("Reporte");
        btReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarReporteCorte(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(btReporte, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de Inicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Fecha Final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(jLabel6, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarCorte(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarCorte
        // TODO add your handling code here:

        //Creamos variable para guardar el corte
        ModeloCorte ventas = null;
        //Creamos controlador corte
        ControlCorte ctrCorte = new ControlCorte();

        txFechaInicio.setDateFormatString("yyy-MM-dd");
        txFechaFinal.setDateFormatString("yyy-MM-dd");
        String fecha1 = "";
        String fecha2 = "";

        if (txFechaInicio.getCalendar() != null) {
            fecha1 = txFechaInicio.getCalendar().get(Calendar.YEAR) + "-" + (txFechaInicio.getCalendar().get(Calendar.MONTH) + 1) + "-" + txFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
        } else {
            JOptionPane.showMessageDialog(this, "Fecha de inicio incorrecta.");
        }

        if (txFechaFinal.getCalendar() != null) {
            fecha2 = txFechaFinal.getCalendar().get(Calendar.YEAR) + "-" + (txFechaFinal.getCalendar().get(Calendar.MONTH) + 1) + "-" + txFechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH);
        } else {
            JOptionPane.showMessageDialog(this, "Fecha final incorrecta.");
        }
        ventas = ctrCorte.realizarCorte(fecha1, fecha2);

        if (ventas == null) {
            JOptionPane.showMessageDialog(this, " No existen registros de ventas para ese rango de fechas  ");
        } else {

            //txUsuario.setText(ventas.getIdUsuario());
            txNoVentas.setText(ventas.getNumVentas().toString());
            txDineroVentas.setText(ventas.getTotal().toString());
            //txDevoluciones.setText(ventas.getDevoluciones().toString());
          //  txEntradas.setText(ventas.getIngresos().toString());
         //   txRetiro.setText(ventas.getRetiros().toString());
            txTotal.setText(ventas.getCorte().toString());

        }

    }//GEN-LAST:event_iniciarCorte

    private void btLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLimpiarMouseClicked
        // TODO add your handling code here:


        VistaCorte vista = new VistaCorte(fecha);
        this.removeAll();
        this.setLayout(new java.awt.BorderLayout());
        this.add(vista);
        vista.show();
        this.revalidate();
        this.repaint();

    }//GEN-LAST:event_btLimpiarMouseClicked

    private void mostrarReporteCorte(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarReporteCorte
        // TODO add your handling code here:

        ModeloCorte reporte = null;
        //Creamos controlador corte
        ControlReporte ctrCorte = new ControlReporte();

        //Le damos formato a la fecha para que mySQL la reconozca
        txFechaInicio.setDateFormatString("yyy-MM-dd");
        txFechaFinal.setDateFormatString("yyy-MM-dd");
        String fecha1 = "";
        String fecha2 = "";

        //Obtenemos los valores de la texto de la fecha del calendario
        if (txFechaInicio.getCalendar() != null) {
            fecha1 = txFechaInicio.getCalendar().get(Calendar.YEAR) + "-" + (txFechaInicio.getCalendar().get(Calendar.MONTH) + 1) + "-" + txFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
        } else {
            JOptionPane.showMessageDialog(this, "Fecha de inicio incorrecta.");
        }

        if (txFechaFinal.getCalendar() != null) {
            fecha2 = txFechaFinal.getCalendar().get(Calendar.YEAR) + "-" + (txFechaFinal.getCalendar().get(Calendar.MONTH) + 1) + "-" + txFechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH);
        } else {
            JOptionPane.showMessageDialog(this, "Fecha final incorrecta.");
        }
        reporte = ctrCorte.realizarReporteCorte(fecha1, fecha2);

        if (reporte == null) {
            JOptionPane.showMessageDialog(this, " No existen registros de ventas para ese rango de fechas  ");
        } else {
            ctrCorte.realizarReporteCorte(fecha1, fecha2);
            JOptionPane.showMessageDialog(null, "Reporte guardado con exito");
        }
    }//GEN-LAST:event_mostrarReporteCorte

    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCorte;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btReporte;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txDineroVentas;
    private com.toedter.calendar.JDateChooser txFechaFinal;
    private com.toedter.calendar.JDateChooser txFechaInicio;
    private javax.swing.JTextField txNoVentas;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}