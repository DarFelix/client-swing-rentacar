
package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
	private Integer idUser;
	private String cedula;
	private String nombre;
	private String apellido;
	private Integer age;
	private String telefono;
	private String direccion;
	private String barrio;
	private String ciudad;
	private String foto;
	private Boolean reporte;
	private String pass;
	private Rol rol;
        

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Boolean isReporte() {
		return reporte;
	}
	public void setReporte(Boolean reporte) {
		this.reporte = reporte;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", age=" + age + ", telefono=" + telefono + ", direccion=" + direccion + ", barrio=" + barrio + ", ciudad=" + ciudad + ", foto=" + foto + ", reporte=" + reporte + ", pass=" + pass + ", rol=" + rol + '}';
    }
	
	

}