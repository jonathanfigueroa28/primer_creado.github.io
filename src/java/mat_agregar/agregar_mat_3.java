
package mat_agregar;

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
import model.*;

@WebServlet(urlPatterns = {"/agregar_mat_3"})

public class agregar_mat_3 extends HttpServlet{
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
        String  nombreMaterial ;
        int codMaterial,cantidad ;
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            funcionesMaterial agregar = new funcionesMaterial();
            
            
            codMaterial =  Integer.parseInt(request.getParameter("codMaterial"));
            
            nombreMaterial = request.getParameter("nombreMaterial");
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            
            agregar.agregar_material(new Material(codMaterial,3,cantidad,nombreMaterial));
            response.setContentType("text/html;charset=UTF-8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados de actualización</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Exitosamente añadido</h2>");
            out.println("</body>");
            
            
            
            out.println("<table border = \"1\"> <tr>");
            out.println("<td> <a href=\"agregar_mat3.html\">(+)agregar otro material </a> </td>");
            out.println("</tr> </table>");
            
             out.println("<form action = \"materiales3\"> <pre>");
             out.println("<input type=\"submit\" value=\"VER LA CAJITA DE MATERIALES\"/>");   
             out.println("</pre> </from>");   
             
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
