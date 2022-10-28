package NEO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ejecutar {

	public static void main(String[] args) throws IOException, InterruptedException {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		CrearProcesoCalculo cal = new CrearProcesoCalculo();
		List<String>a=cal.leer();
		int contador=0;
		for(int i=0;i<a.size();i++) {
			String[] elementos=a.get(i).split(",");
			cal.crearProceso(Double.valueOf(elementos[1]),Double.valueOf(elementos[2]),elementos[0].toString());
			if(contador==12) {
				cal.p.waitFor();
				contador=0;
			}
			contador++;
		}
		time_end = System.currentTimeMillis();
		System.out.println("Tiempo de lanzamiento de procesos "+ ( time_end - time_start ) +" milliseconds");
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
