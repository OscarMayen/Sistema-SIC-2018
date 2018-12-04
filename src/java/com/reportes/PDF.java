/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes;

import com.conexion.Conexion;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author nmayen
 */
public class PDF {
     

     /**
     * Metodo que ejecuta un reporte y lo exporta en pdf.
     * @param datSource String nombre del DataSource.
     * @param url Direccion uri donde esta el jsaper.
     * @param parameters map de los parametros del reporte.
     * @throws java.lang.Exception error general.
     */
    
    public byte[] crearPDF(String rutaRpt,
            Map parameters) throws IOException, NamingException,
            SQLException, Exception {
        String archJasper;
        URI uriObj = null;
        byte[] reporteByte = null;
        Connection conn = null;
        try {
            Conexion connect = new Conexion();
            connect.conectar();
            conn = connect.getCon();
            if (conn == null) {
                throw new Exception("No se puede establece la conexion a la BD");
            }
            uriObj = getClass().getResource(rutaRpt).toURI();
            File reporte = new File(uriObj);
            archJasper = reporte.getAbsolutePath();
            JasperPrint impresion = null;
            JRExporter exporter = new JRPdfExporter();
            ByteArrayOutputStream reportePDF = new ByteArrayOutputStream();
            reporteByte = JasperRunManager.runReportToPdf(reporte.getPath(),
                    parameters, conn);
            impresion =
               JasperFillManager.fillReport(archJasper, parameters, conn);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, impresion);
           exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, reportePDF);
           conn.close();
        } catch (NamingException ne) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE,
                    null, ne);
            throw new Exception("Error al accededer al DataSource "
                    + ne.getMessage());
        } catch (SQLException sqle) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE,
                    null, sqle);
            throw new Exception("SQL Exception " + sqle.getMessage());
        } catch (JRException ex) {
            Logger.getLogger(PDF.class.getName())
                    .log(Level.SEVERE, null, ex);
            throw new Exception("JRException " + ex.getMessage());
        } catch (Exception e) {
            Logger.getLogger(PDF.class.getName())
                    .log(Level.SEVERE, null, e);
            e.printStackTrace();
            throw new Exception("Exception " + e.getMessage());
        } finally {
            conn.close();
        }
        return reporteByte;
    }
    
}
