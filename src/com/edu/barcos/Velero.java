package com.edu.barcos;

public class Velero extends Barco implements INautica {

	public Velero(int id_barco, modelo modelo, String descripcion) {
		super (id_barco, modelo, descripcion);
	}

	@Override
	public void arrancarMotor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void desplegarVela() {
		for (int i=0; i<5; i++) {
			System.out.println("Velero desplegando vela " +i);
		}

	}

	@Override
	public void pararMotor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void replegarVela() {
		for (int i=0; i<5; i++) {
			System.out.println("Velero replegando vela " +i);
		}
		System.out.println("Velero en camino");
	}
	
	@Override
	public void run(){
		System.out.println("Velero saliendo de puerto");
		this.desplegarVela();
		//this.replegarVela();
				
	}
	
	@Override
	public String toString(){
		return "Velero { id_barco: " +this.getId_barco() +", modelo:" +this.getModelo() +", descripcion: " +this.getDescripcion()+"}";
				
	}
		
	

}
