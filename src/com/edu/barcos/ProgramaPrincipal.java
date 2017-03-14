package com.edu.barcos;

import java.util.Scanner;

import com.edu.barcos.Barco.modelo;
import com.edu.barcos.Conexion;
import com.edu.barcos.Query;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		/*System.out.println("Bienvenido al programa generador de carreras de Barcos");
		Velero Bergantin = new Velero();
		Portaaviones Einsenhower = new Portaaviones();
		
		System.out.println("La carrera comienza ¡YA!");
		System.out.println("");
		Bergantin.start();
		Einsenhower.start();
		*/
	
		Scanner teclado = new Scanner(System.in);
		Query q = new Query(new Conexion());
		String opcion = "", descripcion, modelo_str, nombre, localizacion;
		int id_barco, id_puerto, peaje, id_puerto_salida, id_puerto_llegada;
		modelo mod = null;
		Barco ganador = new Barco();
		
		while (!opcion.equals("9")){
			System.out.println("");
			System.out.println("Bienvenido, elija una de las siguientes opciones:");
			System.out.println("1 - Da de alta un nuevo barco");
			System.out.println("2 - Da de alta un nuevo puerto");
			System.out.println("3 - Mostrar barcos disponibles");
			System.out.println("4 - Mostrar puertos disponibles");
			System.out.println("5 - Entrada de barco a puerto");
			System.out.println("6 - Salida de barco de puerto");
			System.out.println("7 - Carrera de barcos");
			System.out.println("9 - Salir");
			opcion = teclado.nextLine();
			//System.out.println("He recogido: "+opcion);
			//Según la opción:
			switch(opcion){
				case "1": 	System.out.println("Introduce los datos del barco a dar de alta");
							System.out.println("Modelo: Velero, Fragata o Portaaviones");
							modelo_str = teclado.nextLine();
							if (modelo_str.equalsIgnoreCase("Velero")) {
								mod = modelo.VELERO;
							} else if (modelo_str.equalsIgnoreCase("Portaaviones")) {
								mod = modelo.PORTAAVIONES;
							} else if (modelo_str.equalsIgnoreCase("Fragata")) {
								mod = modelo.FRAGATA;
							} else {
								System.out.println("Modelo de barco incorrecto"); 
								break; 
							}
							System.out.println("Descripcion:");
							descripcion = teclado.nextLine();
							//System.out.println("Introduciendo datos....");
							q.newBarco(mod, descripcion);
							break;
							
				case "2":	System.out.println("Introduce los datos del puerto a dar de alta");
							System.out.println("Nombre:");
							nombre = teclado.nextLine();
							System.out.println("Localizacion:");
							localizacion = teclado.nextLine();
							//System.out.println("Introduciendo datos....");
							q.newPuerto(nombre, localizacion);
							break;
							
				case "3": 	System.out.println("Los barcos registrados en el sistema son:");
							q.showBarcos();
							
							break;
				
				case "4": 	System.out.println("Los puertos registrados en el sistema son:");
							q.showPuertos();
				
							break;
				
				case "5":	System.out.println("Introduce el ID del barco que está llegando a puerto");
							id_barco = Integer.parseInt(teclado.nextLine());
							if (!q.existsBarco(id_barco)) {
								System.out.println("El barco introducido no existe en el sistema");
								break;
							}
							System.out.println("Introduce el ID del puerto en el que está efectuando la entrada");
							id_puerto = Integer.parseInt(teclado.nextLine());
							if (!q.existsPuerto(id_puerto)) {
								System.out.println("El puerto introducido no existe en el sistema");
								break;
							}
							System.out.println("Indica el peaje a pagar por la entrada al puerto");
							peaje = Integer.parseInt(teclado.nextLine());
							q.entradaBarco(id_barco, id_puerto, peaje, -1);							
									
							break;
				
				case "6": 	System.out.println("Introduce el ID del barco que está saliendo del puerto");
							id_barco = Integer.parseInt(teclado.nextLine());
							if (!q.existsBarco(id_barco)) {
								System.out.println("El barco introducido no existe en el sistema");
								break;
							}
							System.out.println("Introduce el ID del puerto en el que está efectuando la salida");
							id_puerto = Integer.parseInt(teclado.nextLine());
							if (!q.existsPuerto(id_puerto)) {
								System.out.println("El puerto introducido no existe en el sistema");
								break;
							}
							q.salidaBarco(id_barco, id_puerto);
							
							break;
							
				case "7": 	System.out.println("Carreraaaaaaaaa");
							//Barco participantes[] = new Barco[q.numBarcos()];
							Barco participantes[] = q.getBarcos();
							System.out.println("Los barcos participantes son:");
							for (int i=0; i<participantes.length; i++) {
								System.out.println(participantes[i].toString());
							}
							System.out.println("Introduce el ID del puerto de salida");
							id_puerto_salida = Integer.parseInt(teclado.nextLine());
							if (!q.existsPuerto(id_puerto_salida)) {
								System.out.println("El puerto introducido no existe en el sistema");
								break;
							}
							System.out.println("Introduce el ID del puerto de llegada");
							id_puerto_llegada = Integer.parseInt(teclado.nextLine());
							if (!q.existsPuerto(id_puerto_llegada)) {
								System.out.println("El puerto introducido no existe en el sistema");
								break;
							}
							ganador = q.carrera(id_puerto_salida, id_puerto_llegada, participantes);
							
							System.out.println("");
							System.out.println("El ganador de la carrera es: " +ganador.toString());
							break;
							
				case "9": 	System.out.println("Gracias por jugar con nosotros :)");
							break;
			}
		}
		
	}

}
