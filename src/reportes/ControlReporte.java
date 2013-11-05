/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import articulo.Articulo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import venta.ArticuloVenta;
import venta.Venta;

/**
 *
 * @author Administrator
 */
public class ControlReporte {

    public ModeloCorte realizarReporteCorte(String fecha1, String fecha2) {

//Corte reportePdf=new Corte(true);

        ModeloCorte reporte = null;

        //Iniciamos objetos necesarios para la busqueda.
        Venta mVentas = new Venta(true);
        Object[] ventas = null;
        ModeloCorte corteCaja = new ModeloCorte();
        //Parametros de busqueda.
        Object[][] opciones = new Object[][]{{"fecha", ">=", fecha1}, {"fecha", "<=", fecha2}};

        ventas = mVentas.buscarBD("all", opciones);

        Integer tmpNoVentas = 0;
        // String tmpUsuario = " ";
        Float tmpVentas = 0F;
        Float tmpDev = 0F;
        Float tmpEntradas = 0F;
        Float tmpRetiros = 0F;
        Float tmpTotal = 0F;
        Float tmpCorte = 0F;

        int x = 0;

        if (ventas.length <= 0) {
            return null;
        } else {
            for (x = 0; x < ventas.length; x++) {

                //tmpUsuario = ((Venta) ventas[x]).getIdUsuario();
                //tmpDev += ((Venta) ventas[x]).getDevolucion();
                tmpVentas += ((Venta) ventas[x]).getTotal();
               // tmpEntradas += ((Venta) ventas[x]).getIngresos();
              //  tmpRetiros += ((Venta) ventas[x]).getRetiros();
                tmpNoVentas++;

            }
            //  tmpTotal = tmpVentas + tmpEntradas - tmpDev - tmpRetiros;
            tmpCorte = tmpVentas + tmpEntradas - tmpRetiros;
        }

        try {
            //Obtenemos la fecha del reporte y la separamos en mes dia y año.
            Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            String fechaDia = (month + "/" + day + "/" + year);

            //Creamos la variable docmuent de tipo Document
            Document document = new Document();
            //Abrimos el flujo para escribir en el PDF.
            PdfWriter.getInstance(document, new FileOutputStream("Reporte de Corte de Caja.pdf"));
            document.open();
            Image logo = Image.getInstance("logo200.png");
            document.add(logo);

            //Creamos el documento y le damos formato con una tabla
            document.add(new Paragraph("Reporte de Corte de Caja" + "                                             " + fechaDia, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, BaseColor.LIGHT_GRAY)));
            document.add(new Paragraph("**************************************************************************************************************"));
            PdfPTable table = new PdfPTable(2);
            PdfPCell cell = new PdfPCell(new Paragraph("Corte del dia " + fecha1 + " al " + fecha2));
            cell.setColspan(4);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            //table.addCell("Encargado de Caja");
            //table.addCell(tmpUsuario);
            table.addCell("Numero de Ventas");
            table.addCell(tmpNoVentas.toString());
            table.addCell("Dinero de Ventas");
            table.addCell(tmpVentas.toString());
            table.addCell("Entradas de Dinero");
            table.addCell(tmpEntradas.toString());
            //  table.addCell("Devoluciones");
            //  table.addCell(tmpDev.toString());
            table.addCell("Retiros");
            table.addCell(tmpRetiros.toString());
            table.addCell("Total");
            table.addCell(tmpCorte.toString());

            document.add(table);

            //Cerramos PDF.

            document.close();

            try {
                String ruta = "Reporte de Corte de Caja.pdf";
                Desktop.getDesktop().open(new File(ruta));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return corteCaja;
    }

    public ModeloCorte realizarReporteVentas(String fecha1, String fecha2) {

//Corte reportePdf=new Corte(true);

        ModeloCorte reporte = null;

        //Iniciamos objetos necesarios para la busqueda.
        ArticuloVenta mVentas = new ArticuloVenta(true);
        Object[] ventas = null;
        ModeloCorte reporteVentas = new ModeloCorte();
        //Parametros de busqueda.
        Object[][] opciones = new Object[][]{{"fecha", ">=", fecha1}, {"fecha", "<=", fecha2}};

        ventas = mVentas.buscarBD("all", opciones);

        Long tmpIdVenta;
        //String tmpIdUsuario;
        Long tmpIdArticulo;
        String tmpDescripcion = "";
        Integer tmpCantidad;
        Float tmpIva = 0f;
        Float tmpSubTotal = 0f;
        Float tmpTotal;
        String tmpFecha = "";
        Float tmpIngresos = 0F;
        Float tmpRetiros = 0F;




        int x = 0;

        if (ventas.length <= 0) {
            return null;
        } else {

            try {
                //Obtenemos la fecha del reporte y la separamos en mes dia y año.
                Calendar cal = new GregorianCalendar();
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                String fechaDia = (month + "/" + day + "/" + year);

                //Creamos la variable docmuent de tipo Document
                Document document = new Document();
                //Abrimos el flujo para escribir en el PDF.
                PdfWriter.getInstance(document, new FileOutputStream("Reporte de Ventas.pdf"));
                document.open();
                Image logo = Image.getInstance("logo200.png");
                document.add(logo);

                //Creamos el documento y le damos formato con una tabla
                document.add(new Paragraph("Reporte de Ventas" + "                                             " + fechaDia, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, BaseColor.LIGHT_GRAY)));
                document.add(new Paragraph("**************************************************************************************************************"));
                PdfPTable table = new PdfPTable(10);
                PdfPCell cell = new PdfPCell(new Paragraph("Reporte de Ventas "));
                cell.setColspan(10);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
                table.addCell("Id de Venta");
                // table.addCell("Usuario");
                table.addCell("Id Articulo");
                table.addCell("Descripción");
                table.addCell("Cantidad");
                table.addCell("IVA");
                table.addCell("Subtotal");
                table.addCell("Total");
                //table.addCell("Efectivo");
                table.addCell("Fecha");
                table.addCell("Ingresos");
                table.addCell("Retiros");




                for (x = 0; x < ventas.length; x++) {
                    tmpIdVenta = ((Venta) ventas[x]).getIdVenta();
                    //tmpIdUsuario = ((Venta) ventas[x]).getIdUsuario();
                    tmpIdArticulo = ((ArticuloVenta) ventas[x]).getIdArticulo();
                    //tmpDescripcion = ((ArticuloVenta) ventas[x]).getDescripcion();
                    tmpCantidad = ((ArticuloVenta) ventas[x]).getCantidad();
                   // tmpIva = ((ArticuloVenta) ventas[x]).getIva();
                   // tmpSubTotal = ((ArticuloVenta) ventas[x]).getSubTotal();
                    tmpTotal = ((ArticuloVenta) ventas[x]).getTotal();
                   // tmpFecha = ((ArticuloVenta) ventas[x]).getFecha();
                   // tmpIngresos = ((Venta) ventas[x]).getIngresos();
                  //  tmpRetiros = ((Venta) ventas[x]).getRetiros();


                    table.addCell(tmpIdVenta.toString());
                    //table.addCell(tmpIdUsuario);
                    table.addCell(tmpIdArticulo.toString());
                    table.addCell(tmpDescripcion);
                    table.addCell(tmpCantidad.toString());
                    table.addCell(tmpIva.toString());
                    table.addCell(tmpSubTotal.toString());
                    table.addCell(tmpTotal.toString());
                    table.addCell(tmpFecha);
                    table.addCell(tmpIngresos.toString());
                    table.addCell(tmpRetiros.toString());
                }

                document.add(table);

                //Cerramos PDF.
                document.close();
                try {
                    String ruta = "Reporte de Ventas.pdf";
                    Desktop.getDesktop().open(new File(ruta));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return reporteVentas;
    }

    public ModeloArticulo realizarReporteArticulo() {

        //Articulo reporte = null;

        //Iniciamos objetos necesarios para la busqueda.
        Articulo mArticulo = new Articulo(true);
        Object[] articulos = null;
        ModeloArticulo reporteArticulos = new ModeloArticulo();
        //Parametros de busqueda.
        Boolean activo = true;
        Object[][] opciones = new Object[][]{{"idArticulo", ">=", activo}};

        articulos = mArticulo.buscarBD("all", opciones);

        Long tmpIdArticulo;
        Long tmpCodigoArticulo;
        String tmpDescripcion = " ";
        Float tmpPrecioCompra = 0F;
        Float tmpPrecioVenta = 0F;
        Integer tmpCantidadExistencia;
        String tmpProveedor = " ";
        Boolean tmpActivo;
        int x = 0;

        if (articulos.length <= 0) {
            return null;
        } else {

            try {
                //Obtenemos la fecha del reporte y la separamos en mes dia y año.
                Calendar cal = new GregorianCalendar();
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                String fechaDia = (month + "/" + day + "/" + year);

                //Creamos la variable docmuent de tipo Document
                Document document = new Document();
                //Abrimos el flujo para escribir en el PDF.
                PdfWriter.getInstance(document, new FileOutputStream("Reporte de Articulos.pdf"));
                document.open();
                Image logo = Image.getInstance("logo200.png");
                document.add(logo);

                //Creamos el documento y le damos formato con una tabla
                document.add(new Paragraph("Reporte Almacen" + "                                             " + fechaDia, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, BaseColor.LIGHT_GRAY)));
                document.add(new Paragraph("**************************************************************************************************************"));
                PdfPTable table = new PdfPTable(7);
                PdfPCell cell = new PdfPCell(new Paragraph("Reporte de Articulos en Almacen "));
                cell.setColspan(7);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
                table.addCell("Id de Articulo");
                table.addCell("Codigo de Articulo");
                table.addCell("Descripcion");
                table.addCell("Precio de Compra");
                table.addCell("Precio de Venta");
                table.addCell("Cantidad en extistencia");
                table.addCell("Proveedor");



                for (x = 0; x < articulos.length; x++) {
                    tmpIdArticulo = ((Articulo) articulos[x]).getIdArticulo();
                    tmpCodigoArticulo = ((Articulo) articulos[x]).getCodigoArticulo();
                    tmpDescripcion = ((Articulo) articulos[x]).getDescripcion();
                    tmpPrecioCompra = ((Articulo) articulos[x]).getPrecioCompra();
                    tmpPrecioVenta = ((Articulo) articulos[x]).getPrecioVenta();
                    tmpCantidadExistencia = ((Articulo) articulos[x]).getCantidadExistencia();
                    tmpProveedor = ((Articulo) articulos[x]).getProveedor();
                    //tmpActivo = ((Articulo) articulos[x]).getActivo();

                    table.addCell(tmpIdArticulo.toString());
                    table.addCell(tmpCodigoArticulo.toString());
                    table.addCell(tmpDescripcion);
                    table.addCell(tmpPrecioCompra.toString());
                    table.addCell(tmpPrecioVenta.toString());
                    table.addCell(tmpCantidadExistencia.toString());
                    table.addCell(tmpProveedor);
                }

                document.add(table);

                //Cerramos PDF.
                document.close();
                try {
                    String ruta = "Reporte de Articulos.pdf";
                    Desktop.getDesktop().open(new File(ruta));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }


        return reporteArticulos;

    }
}
