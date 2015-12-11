/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author olman castillo
 */
public class anime_manga {
    private String nombre;
    private String tipo;
    private String generos;
    private String descrision;
    private boolean visto;
    private int fecha;
    private String imagen;

    public anime_manga(String nombre, String tipo, String generos, String descrision, boolean visto, int fecha, String imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.generos = generos;
        this.descrision = descrision;
        this.visto = visto;
        this.fecha = fecha;
        this.imagen = imagen;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getDescrision() {
        return descrision;
    }

    public void setDescrision(String descrision) {
        this.descrision = descrision;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
