
package util;

import java.sql.*;

public class coneccion {
    static Connection conn = null;
    
    public static Connection conectar_my(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/materiales_educativos";
            conn = DriverManager.getConnection(url,"root","gatovolador");
        }   
        catch (Exception e){
        }
        return conn;
    }
}
