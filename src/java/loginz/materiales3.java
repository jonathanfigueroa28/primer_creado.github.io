
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
import model.*;

@WebServlet(urlPatterns = {"/materiales3"})

public class materiales3 extends HttpServlet{
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
            funcionesMaterial listac = new funcionesMaterial();
            List<Categoria> cats = listac.listar_cat();
            
            funcionesMaterial lista = new funcionesMaterial();
            List<Material> mats = lista.listar_mat_cat(3);
            
            
            
            
            response.setContentType("text/html;charset=UTF-8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados de muestreo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h2>CATEGORIA 3: LIBROS</h2></center>");
            
            //TOOS DEBEN TENER ESTO QUE ES LA TABLA DE CATEGORIAS
            out.println("<form action=\"redireccionar_cat\"><select name=\"codCategoria\" id= \"codCategoria\" size=3 >");
               for(int i =0;i<cats.size();i++){
                   out.println("<option value="+"'"+cats.get(i).getCodCategoria()+"'"+">"+cats.get(i).getNombreCategoria()+ "</option>");
            }
            out.println("</select>");
               out.println("<input type =\"submit\" name =\"boton\" value =\"Elegir\">");
               out.println("</form>");
            
            
            //TOOS DEBEN TENER ESTO QUE ES LA TABLA DE MATERIALES DE LA CATEGORIA
             out.println(" <p></p>");
            out.println("<form action=\"agregar_cantidad\"><select name=\"nombreMaterial\" id= \"nombreMaterial\" size=3 >");
            for(int i =0;i<mats.size();i++){
               out.println("<option value="+"'"+mats.get(i).getNombreMaterial()+"'"+">"
                       +mats.get(i).getNombreMaterial() + " ("+mats.get(i).getCantidad()+")"+"</option>");
            }
            out.println("</select> <input type =\"submit\" name =\"boton\" value =\"Agregar cantidad\"> </form>"); 
                        
            //LINKS PARA REGRESAR Y AGREGAR(VA PARA TODOS)
           
            out.println("<table border = \"1\"> <tr>");
            out.println("<td> <a href=\"agregar_mat3.html\">(+)agregar material </a> </td>");
            out.println("</tr> </table>");
            
             out.println("<form action = \"proto\"> <pre>");
             out.println("<input type=\"submit\" value=\"regresar(INICIO)\"/>");   
             out.println("</pre> </form>");
            
             out.println(" <p>********************************************************************************************************</p>");
            out.println(" <p>********************************************************************************************************</p>");
            out.println(" <p>******************************MIRANDOLO COMO TABLA DE SQL*****************************************</p>");
            out.println(" <p>********************************************************************************************************</p>");
            out.println(" <p>********************************************************************************************************</p>");
             
            out.println(" <table border = 1>");
            out.println(" <tr>");
            out.println(" <th> CodCategoria  </th>");
            out.println(" <th> nombreCategoria  </th>");
            out.println(" <th> descripcionCategoria  </th>");
            out.println(" </tr>");
            for(int i =0;i<cats.size();i++){
               out.println(" <tr>");
                    out.println(" <td> "+cats.get(i).getCodCategoria()+"</td>");
                    int x = cats.get(i).getCodCategoria();
                    String y= "'categoria"+x+".html'>";
                    out.println(" <td><a href="+y +cats.get(i).getNombreCategoria()
                            +"</a> </td>");
                    out.println(" <td> "+cats.get(i).getDescripcionCategoria()+"</td>");
               out.println(" </tr>"); 
            }
            
            out.println(" </table>");
            
            //TOOS DEBEN TENER ESTO QUE ES LA TABLA DE MATERIALES DE LA CATEGORIA
            out.println(" <p></p>");
            out.println(" <table border = 1>");
            out.println(" <tr>");
            out.println(" <th> CodMaterial  </th>");
            out.println(" <th> nombreMaterial  </th>");
            out.println(" <th> cantidad  </th>");
            out.println(" </tr>");
            for(int i =0;i<mats.size();i++){
               out.println(" <tr>");
                    out.println(" <td> "+mats.get(i).getCodMaterial()+"</td>");
                    out.println(" <td> "+mats.get(i).getNombreMaterial()+"</td>");
                    out.println(" <td> "+mats.get(i).getCantidad()+"</td>");
                    
               out.println(" </tr>"); 
            }
             
            out.println(" </table>"); 
             
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
