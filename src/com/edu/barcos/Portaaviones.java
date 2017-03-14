package com.edu.barcos;

public class Portaaviones extends Barco implements INautica {

	public Portaaviones(modelo modelo, String descripcion) {
		super (modelo, descripcion);
	}

	@Override
	public void arrancarMotor() {
		for (int i=0; i<5; i++) {
			System.out.println("Portaaviones arrancando motor " +i);
		}
		System.out.println("Portaaviones en camino");

	}

	@Override
	public void desplegarVela() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pararMotor() {
		for (int i=0; i<5; i++) {
			System.out.println("Portaaviones apagando motor " +i);
		}

	}

	@Override
	public void replegarVela() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(){
		System.out.println("Portaaviones saliendo de puerto");
		this.arrancarMotor();
		//this.pararMotor();
				
	}

	@Override
	public String toString(){
		return "Portaaviones { id_barco: " +this.getId_barco() +", modelo:" +this.getModelo() +", descripcion: " +this.getDescripcion()+"}";
				
	}
}
