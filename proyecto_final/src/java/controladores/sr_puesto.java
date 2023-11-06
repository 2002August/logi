/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.puesto;

/**
 *
 * @author augus
 */
public class sr_puesto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    puesto Puesto;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_puesto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sr_puesto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
         if ("agregar".equals(request.getParameter("btn_agregar"))){
            Puesto = new puesto(Integer.parseInt(request.getParameter("txt_id_puesto")),request.getParameter("txt_puesto"));
            
            if (Puesto.agregar() > 0) {
                response.sendRedirect("puesto.jsp");
            /*out.println("<h1> Ingreso Exitoso </h1>");
            out.println("<a href ='index.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='puesto.jsp'> Regresar </a>");
             
             }
            }
            
            
            
            
            if ("modificar".equals(request.getParameter("btn_modificar"))){
            Puesto = new puesto(Integer.parseInt(request.getParameter("txt_id_puesto")),request.getParameter("txt_puesto"));
            
            if (Puesto.modificar() > 0) {
                response.sendRedirect("puesto.jsp");
            /*out.println("<h1> No se elimino</h1>");
            out.println("<a href ='index.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> No se modifico.... </h1>"); 
               out.println("<a href ='puesto.jsp'> Regresar </a>");
             
             }
            }
            
            
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
            Puesto = new puesto(Integer.parseInt(request.getParameter("txt_id_puesto")),request.getParameter("txt_puesto"));
            
            if (Puesto.eliminar() > 0) {
                response.sendRedirect("puesto.jsp");
            /*out.println("<h1> No se elimino</h1>");
            out.println("<a href ='index.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='puesto.jsp'> Regresar </a>");
             
             }
            }

            
            out.println("</body>");
            out.println("</html>");
        }
    }

        }

   