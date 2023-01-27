
package model;

public class Material {
    int codMaterial,codCategoria,cantidad;
    String nombreMaterial;

    public Material() {
    }
    
    public Material(int codMaterial, int codCategoria, int cantidad, String nombreMaterial) {
        this.codMaterial = codMaterial;
        this.codCategoria = codCategoria;
        this.cantidad = cantidad;
        this.nombreMaterial = nombreMaterial;
    }

    public int getCodMaterial() {
        return codMaterial;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }
    
}
