/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes;

import com.conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Generar", urlPatterns = {"/Generar"})
public class Generar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        PDF imprpt = new PDF();
        byte[] reporteByte = null;
        
        String rutarpt =     (String) request.getSession().getAttribute("rutarpt");
        Map param = (Map) request.getSession().getAttribute("param");
       
         //String rutarpt =    "/com/reportes/rpt.jasper";
         //Map parameters = (Map) request.getSession().getAttribute("parameters");

         Map parameters = new HashMap();

        if (rutarpt == null || rutarpt.equals("")){
            PrintWriter out = response.getWriter();
            out.println("<h2>El parametro rutarpt del reporte no es valida </h2>");
            out.close();
            return;
        }


//        if (parameters == null){
//            PrintWriter out = response.getWriter();
//            out.println("<h2>Los parametro del reporte no son validos </h2>");
//            out.close();
//            return;
//        }
        try {
            
            reporteByte = imprpt.crearPDF(rutarpt, parameters);
            response.setContentType("application/pdf");
            response.setContentLength(reporteByte.length);
            response.getOutputStream().write(reporteByte);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (SQLException ex) {
            Logger.getLogger(Generar.class.getName())
                    .log(Level.SEVERE, null, ex);
            PrintWriter out = response.getWriter();
            out.println("<H2> Error: " + ex.getMessage() + "</H2>");
            ex.printStackTrace();
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(Generar.class.getName())
                    .log(Level.SEVERE, null, ex);
            PrintWriter out = response.getWriter();
            out.println("<H2> Error: " + ex.getMessage() + "</H2>");
            out.close();
        } finally {
            request.getSession()
                   .removeAttribute("parameters");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
