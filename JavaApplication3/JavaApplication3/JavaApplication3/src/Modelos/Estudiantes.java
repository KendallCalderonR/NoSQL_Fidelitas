/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author kenda
 */
public class Estudiantes {
    
    private String id;
    private String nombre;
    private String años;
    private String genero;

    public Estudiantes(String id, String nombre, String años, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.años = años;
        this.genero = genero;
    }

    public Estudiantes() {
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAños() {
        return años;
    }

    public void setAños(String años) {
        this.años = años;
    }
    
    
}
