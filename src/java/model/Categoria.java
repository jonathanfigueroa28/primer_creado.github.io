
package model;



public class Categoria {
    int codCategoria;
    String nombreCategoria,descripcionCategoria;

    public Categoria() {
    }
    
    public Categoria(int codCategoria, String nombreCategoria, String descripcionCategoria) {
        this.codCategoria = codCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }
    
}
