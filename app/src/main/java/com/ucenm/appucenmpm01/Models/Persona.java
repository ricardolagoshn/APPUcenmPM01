package com.ucenm.appucenmpm01.Models;

public class Persona
{
    private int id;
    private String nombres;
    private String apellidos;
    private String fechanac;
    private String direccion;
    private String telefono;
    private String correo;

    public Persona() {
    }

    public Persona(String nombres, String apellidos, String fechanac, String direccion, String telefono, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechanac = fechanac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
