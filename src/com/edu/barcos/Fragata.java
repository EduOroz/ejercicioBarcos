package com.edu.barcos;

public class Fragata extends Barco implements INautica {

	public Fragata(modelo modelo, String descripcion) {
		super (modelo, descripcion);
	}

	@Override
	public void arrancarMotor() {
		for (int i=0; i<5; i++) {
			System.out.println("Fragata arrancando motor " +i);
		}
		System.out.println("Fragata en camino");

	}

	@Override
	public void desplegarVela() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pararMotor() {
		for (int i=0; i<5; i++) {
			System.out.println("Fragata parando motor " +i);
		}

	}

	@Override
	public void replegarVela() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(){
		System.out.println("Fragata comienza la carrera");
		this.arrancarMotor();
		System.out.println("Fragata en camino");
		this.pararMotor();
				
	}
	
	@Override
	public String toString(){
		return "Fragata { id_barco: " +this.getId_barco() +", modelo:" +this.getModelo() +", descripcion: " +this.getDescripcion() +"}";
				
	}
}
