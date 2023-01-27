
package junto;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import util.coneccion;
import model.*;
public class funcionesMaterial {
        Connection conn = coneccion.conectar_my();
    public  void agregar_material(Material material ){
        Statement stm = null;
        try{
            String sql = "insert into materiales(codMaterial,codCategoria,nombreMaterial,cantidad) values('"+material.getCodMaterial()+"','"+
                    material.getCodCategoria()+"','"+material.getNombreMaterial()+"','"+material.getCantidad()+"'); ";
            stm=conn.createStatement();
            stm.executeUpdate(sql);
            
        }
        catch (Exception e){
        }
   }
    public  void agregar_cantidad(int codMaterial,int cant_agregar){
        Statement stm = null;
        
        try{
            int cantidad = 0;
            String sql = "SELECT * FROM materiales where codMaterial = "+codMaterial+";";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                cantidad = rs.getInt("cantidad");
            }
            
            
            String sql2 = "update materiales_educativos.materiales set cantidad = "+(cantidad + cant_agregar)+" where codMaterial = "+codMaterial+";";
            stm=conn.createStatement();
            stm.executeUpdate(sql2);
            
        }
        catch (Exception e){
        }
        
   }
    public  List<Material> listar_mat_cat(int codigo_cat){
        String nombreMaterial ; 
        int codMaterial , cantidad;
        List<Material> materiales = new ArrayList<Material>();
        try{
            String sql = "SELECT * FROM materiales where codCategoria = "+codigo_cat+";";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            Material mat;
            while(rs.next()){
                cantidad  = rs.getInt("cantidad");
                nombreMaterial = rs.getString("nombreMaterial");
                codMaterial = rs.getInt("codMaterial");
                mat = new Material(codMaterial,codigo_cat,cantidad,nombreMaterial);
                materiales.add(mat);
            }
        }
        catch (Exception e){
        }
        return materiales;
    }
    public  List<Material> listar_mat(){
        String nombreMaterial ; 
        int codMaterial , cantidad,codigo_cat;
        List<Material> materiales = new ArrayList<Material>();
        try{
            String sql = "SELECT * FROM materiales ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            Material mat;
            while(rs.next()){
                cantidad  = rs.getInt("cantidad");
                nombreMaterial = rs.getString("nombreMaterial");
                codMaterial = rs.getInt("codMaterial");
                codigo_cat = rs.getInt("codCategoria");
                mat = new Material(codMaterial,codigo_cat,cantidad,nombreMaterial);
                materiales.add(mat);
            }
        }
        catch (Exception e){
        }
        return materiales;
    }
    public List<Categoria> listar_cat(){
        int codCategoria;
        String nombreCategoria,descripcionCategoria;
        List<Categoria> categoria = new ArrayList<Categoria>();

        try{
           
            Categoria cat;
            String sql = "SELECT * FROM categorias;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                descripcionCategoria  = rs.getString("descripcionCategoria");
                nombreCategoria = rs.getString("nombreCategoria");
                codCategoria = rs.getInt("codCategoria");
                cat = new Categoria(codCategoria,nombreCategoria,descripcionCategoria);
                categoria.add(cat);
            }
        }
        catch (Exception e){
        } 
        return categoria;
    }
}
