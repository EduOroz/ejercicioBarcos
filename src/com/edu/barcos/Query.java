package com.edu.barcos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.edu.barcos.Barco.modelo;

public class Query {

	Connection con = null;
	
	public Query(Conexion conexion){
		this.con = conexion.getConnection();
	}
	
	public void newBarco(modelo modelo, String descripcion){
		try {
			String query = "insert into barcos (modelo, descripcion) values (?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, modelo.toString());
			preparedStmt.setString(2, descripcion);
			preparedStmt.execute();
			System.out.println("Se ha dado de alta un nuevo barco");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	
	}
	
	public void newPuerto(String nombre, String localizacion){
		try {
			String query = "insert into puertos (nombre, localizacion) values (?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, nombre);
			preparedStmt.setString(2, localizacion);
			preparedStmt.execute();
			System.out.println("Se ha dado de alta un nuevo puerto");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	
	}
	
	public void showBarcos () {
		try {
			String query = "select * from barcos;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while (rs.next()){
				//biblioteca[i] = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("editorial"), rs.getInt("num_paginas"), rs.getString("autor"), rs.getString("año_publicacion"));
				System.out.println("Barco " +rs.getString("id") +": modelo -->" +rs.getString("modelo") +", descripcion -->" +rs.getString("descripcion"));
				i++;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	}
	
	public void showPuertos () {
		
	}
	
	public void entradaBarco (int id_barco, int id_puerto) {
		
	}
	
	public void salidaBarco (int id_barco, int id_puerto) {
		
	}
}
