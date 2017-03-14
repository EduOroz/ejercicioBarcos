package com.edu.barcos;

public class Barco extends Thread {

	private int id_barco;
	private modelo modelo;
	private String descripcion; 
	public enum modelo {VELERO, PORTAAVIONES, FRAGATA}
	
	public Barco(modelo modelo, String descripcion) {
		this.modelo = modelo;
		this.descripcion = descripcion;
	}
	
	public Barco(int id_barco, modelo modelo, String descripcion) {
		this.id_barco = id_barco;
		this.modelo = modelo;
		this.descripcion = descripcion;
	}

	public Barco() {
		// TODO Auto-generated constructor stub
	}

	public modelo getModelo() {
		return modelo;
	}

	public void setModelo(modelo modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getId_barco() {
		return id_barco;
	}

	public void setId_barco(int id_barco) {
		this.id_barco = id_barco;
	}

	
}
