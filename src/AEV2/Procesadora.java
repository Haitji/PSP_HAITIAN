package AEV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Procesadora {
	static int maximoCroquetas = 100;
	
	/**
	 * Este método lanza los hilos en el orden que los recibe en la lista
	 * @param lista_croquetas Introducimos una lista de objetos croquetas
	 */
	synchronized public static void hacerCroquetas(List<Croquetas> lista_croquetas) {
		Croquetas croqueta;
		for(int j=0;j<lista_croquetas.size();j++) {//Recorre la lista
			for (int i = 0; i < lista_croquetas.get(j).getCantidad(); i++) {//lanza el numero de hilos correspondientes
				//Mientras que las maximoCroquetas sea 0 no sale del bucle 
				while(maximoCroquetas==0) {
				System.out.println("Maximo de croqueta en fabricacion alcanzado==============");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Empieza croqueta " + lista_croquetas.get(j).getTipo() + " " + i);
				croqueta = new Croquetas(lista_croquetas.get(j).getTipo(), i+1);
				Thread hilo = new Thread(croqueta);
				hilo.start();
				maximoCroquetas--;//Cada vez que inicializas un hilo reduces maximoCroquetas
			}
		}

			
	}
	
	
	
	/**
	 * Método que recoge los datos y crea una lista de objeto croquetas y los ordena según su prioridad
	 * Para esto creamos un constructor con atributo prioridad en croquetas
	 * @param jamon recoge el numero de croquetas
	 * @param pollo ---
	 * @param bacalao ---
	 * @param queso ---
	 * @param p_jamon recoge la prioridad de la croqueta
	 * @param p_pollo ---
	 * @param p_bacalao ---
	 * @param p_queso ---
	 * @return retorna la lista de croquetas ordenada
	 */
	public static List<Croquetas> ordenarPrioridad(int jamon,int pollo,int bacalao,int queso,int p_jamon,int p_pollo,int p_bacalao,int p_queso){
		List<Croquetas> list = new ArrayList<>();
		list.add(new Croquetas("jamon",jamon,p_jamon));
		list.add(new Croquetas("pollo",pollo,p_pollo));
		list.add(new Croquetas("bacalao",bacalao,p_bacalao));
		list.add(new Croquetas("queso",queso,p_queso));
		
		  Collections.sort(list, new Comparator<Croquetas>() {//Esto te permite ordenar una lista de objetos segun un atributo
		@Override public int compare(Croquetas c1, Croquetas c2) { return new //Ordena de menor a mayor, si lo quemos me mayor a menor solo debemos cambiar el orden de c1 y c2
		  Integer(c1.getPrioridad()).compareTo(new Integer(c2.getPrioridad())); } });
		  
		return list;
	}
	
	public static void main(String[] args) {
		int jamon = Integer.parseInt(args[0]);
		int pollo = Integer.parseInt(args[1]);
		int bacalao = Integer.parseInt(args[2]);
		int queso = Integer.parseInt(args[3]);
		int p_jamon = Integer.parseInt(args[4]);
		int p_pollo = Integer.parseInt(args[5]);
		int p_bacalao = Integer.parseInt(args[6]);
		int p_queso = Integer.parseInt(args[7]);
		
		List<Croquetas> cc=ordenarPrioridad(jamon,pollo,bacalao,queso,p_jamon,p_pollo,p_bacalao,p_queso);
		hacerCroquetas(cc);
		

	}

}
