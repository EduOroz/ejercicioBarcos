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
	
	public boolean existsBarco (int id) {
		boolean exists = false;
		try {
			String query = "select count(*) from barcos where id =" +id +";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				//biblioteca[i] = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("editorial"), rs.getInt("num_paginas"), rs.getString("autor"), rs.getString("año_publicacion"));
				if (rs.getInt(1)==1) {exists = true;};
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
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
	
	public int numBarcos () {
		int num_barcos=0;
		try {
			String query = "select count(*) from barcos;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				num_barcos = rs.getInt(1);
				//System.out.println("Número de barcos en el sistema: " +num_barcos);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num_barcos; 
	}
	
	public Barco[] getBarcos () {
	
		Barco participantes[] = new Barco[numBarcos()];
		
		try {
			String query = "select * from barcos;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while (rs.next()){
				if (rs.getString("modelo").equalsIgnoreCase("Velero")) {
					participantes[i] = new Velero(modelo.VELERO, rs.getString("descripcion"));
				} else if (rs.getString("modelo").equalsIgnoreCase("Fragata")) {
					participantes[i] = new Fragata(modelo.FRAGATA, rs.getString("descripcion"));
				} else if (rs.getString("modelo").equalsIgnoreCase("Portaaviones")) {
					participantes[i] = new Fragata(modelo.PORTAAVIONES, rs.getString("descripcion"));
				}
				//System.out.println(i +": " +biblioteca[i].toString());
				i++;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return participantes;
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
	
	public boolean existsPuerto (int id) {
		boolean exists = false;
		try {
			String query = "select count(*) from puertos where id =" +id +";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				//biblioteca[i] = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("editorial"), rs.getInt("num_paginas"), rs.getString("autor"), rs.getString("año_publicacion"));
				if (rs.getInt(1)==1) {exists = true;};
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}
	
	public void showPuertos () {
		try {
			String query = "select * from puertos;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while (rs.next()){
				//biblioteca[i] = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("editorial"), rs.getInt("num_paginas"), rs.getString("autor"), rs.getString("año_publicacion"));
				System.out.println("Puerto " +rs.getString("id") +": nombre -->" +rs.getString("nombre") +", localizacion -->" +rs.getString("localizacion"));
				i++;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	}
	
	public void entradaBarco (int id_barco, int id_puerto, int peaje, int id_carrera) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		try {
			String query = "insert into entrada (id_puerto, id_barco, fecha_entrada, peaje) values (?,?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, id_puerto);
			preparedStmt.setInt(2, id_barco);
			preparedStmt.setString(3, dateFormat.format(date));
			preparedStmt.setInt(4, peaje);
			preparedStmt.setInt(5, id_carrera);
			preparedStmt.execute();
			System.out.println("Se ha dado de alta una nueva entrada en el puerto " +id_puerto +" para el barco " +id_barco);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	}
	
	public void salidaBarco (int id_barco, int id_puerto) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		try {
			String query = "insert into salida (id_puerto, id_barco, fecha_salida) values (?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, id_puerto);
			preparedStmt.setInt(2, id_barco);
			preparedStmt.setString(3, dateFormat.format(date));
			preparedStmt.execute();
			System.out.println("Se ha dado de alta una nueva salida en el puerto " +id_puerto +" para el barco " +id_barco);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	}
	
	public Barco carrera (int id_puerto_salida, int id_puerto_llegada, Barco[] participantes) {
		Barco ganador = new Barco();
		
		return ganador;
	}
	
}
