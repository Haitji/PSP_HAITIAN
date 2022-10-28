package NEO;

import java.text.DecimalFormat;

public class calculos {

	public static void main(String[] args) {
		double posicion=Double.parseDouble(args[0]);
		double velocity=Double.parseDouble(args[1]);
		String nombre=args[2];
		double pro=calculo(posicion, velocity);
		if(pro>10) {
			System.out.println(nombre+"--"+String.format("%.2f", pro)+"--ALERTA!!");
		}else {
			System.out.println(nombre+"--"+String.format("%.2f", pro)+"--SEGURO");
		}
	}
	public static double calculo(double posicionNEO,double velocidadNEO) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() * Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		time_end = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion "+ ( time_end - time_start ) +" milliseconds");
		return resultado;
	}
	

}
