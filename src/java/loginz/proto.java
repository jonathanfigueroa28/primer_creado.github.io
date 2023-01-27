
package loginz;

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
import model.Categoria;

@WebServlet(urlPatterns = {"/proto"})

public class proto extends HttpServlet{
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
        //response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            funcionesMaterial lista = new funcionesMaterial();
            List<Categoria> cats = lista.listar_cat();
            
            
            
            
            response.setContentType("text/html;charset=UTF-8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados de actualización</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h2>CATEGORIAS</h2></center>");
            
            out.println("<form action=\"redireccionar_cat\"><select name=\"codCategoria\" id= \"codCategoria\" size=3 >");
               for(int i =0;i<cats.size();i++){
                   out.println("<option value="+"'"+cats.get(i).getCodCategoria()+"'"+">"+cats.get(i).getNombreCategoria()+ "</option>");
            }
            out.println("</select>");
               out.println("<input type =\"submit\" name =\"boton\" value =\"Elegir\">");
               out.println("</form>");
            
            out.println("<Br>");
            out.println("<Br>");
            out.println("<p>Advertencia: si no aparecen las categorias, se debe cambiar en Source Packages->util->coneccion.java: cambiar la contraseña y root de mysql, y de ser necesario el class.forname(...)</p>");
            
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

    

