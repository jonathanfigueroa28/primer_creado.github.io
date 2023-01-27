
package loginz;

import com.mysql.cj.util.StringUtils;
import junto.funcionesMaterial;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.*;
import java.util.logging.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.*;

@WebServlet(urlPatterns = {"/agregar_ya"})

public class agregar_ya extends HttpServlet{
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
        agregar_cantidad agree = new agregar_cantidad();
        int cod = agree.codigo;
        int cantidad;
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            funcionesMaterial agregado = new funcionesMaterial();
            agregado.agregar_cantidad(cod, cantidad);
            
            
            response.setContentType("text/html;charset=UTF-8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados de muestreo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>AGREGADO EXITOSAMENTE</h2>");
            //VENTANA DE DIALOGO CON VAR DE RESPUESTA
            
            out.println("<p>cod:"+(cod)+"</p>");
            out.println("<p>cantidad:"+(cantidad)+"</p>");          
            //LINKS PARA REGRESAR Y AGREGAR(VA PARA TODOS)
              
             
             out.println("<form action = \"proto\"> <pre>");
             out.println("<input type=\"submit\" value=\"regresar(INICIO)\"/>");   
             out.println("</pre> </from>");
            out.println("</body>");
            
        } catch (Exception e) {
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
