
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

@WebServlet(urlPatterns = {"/agregar_cantidad"})

public class agregar_cantidad extends HttpServlet{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static int codigo;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cantidad,codMaterial;
        String name,nombreMaterial;
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            funcionesMaterial lista = new funcionesMaterial();
            List<Material> materiales = lista.listar_mat();
            
            name = request.getParameter("nombreMaterial");
            
            int i=0;
            codMaterial=0;
            for( i=0;i<materiales.size();i++){
                if(materiales.get(i).getNombreMaterial().equals(name)){
                    codMaterial = materiales.get(i).getCodMaterial();
                    break;
                }
            }
            this.codigo=codMaterial;
            
            
            response.setContentType("text/html;charset=UTF-8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados de muestreo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Cantidad de "+name+" a agregar: </h2>");
            //VENTANA DE DIALOGO CON VAR DE RESPUESTA
            out.println("<form action=\"agregar_ya\" method=\"get\"><pre>");
            out.println("<input type=\"number\" name=\"cantidad\" placeholder=\"Agregar la cantidad\"/>");
            out.println("<input type=\"submit\" value=\"AGREGAR\"/>"); 
            out.println("</pre></form>");
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
