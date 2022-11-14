package AEV2;


//Constructor
public class Croquetas implements Runnable{
	
	private String tipo;
	private int cantidad;
	private int prioridad;
	private int num;
	
	
//Getters===========================
	public String getTipo() {
		return tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getPrioridad() {
		return prioridad;
	}
//==================================


	
	
	/**
	 * Este constructor sirve para organizar el orden de prioridad de las croquetas 
	 * @param tipo
	 * @param cantidad
	 * @param prioridad
	 */
	public Croquetas(String tipo, int cantidad, int prioridad) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.prioridad = prioridad;
	}
	
	
	
	//Constructor para ejecutar el Runnable
	public Croquetas(String tipo,int num) {
		this.tipo = tipo;
		this.num = num;
	}

	
	
	
	
	/**
	 * Esta funcion ejecuta un Thread.sleep dependiendo del nombre que reciba la clase al ser inicializado
	 */
	public void hacerCroquetas() {
		switch (tipo) {
	    case "jamon":
			try {
					Thread.sleep(5000);
					System.out.println("Croqueta jamon "+num+" terminada");
					Procesadora.maximoCroquetas++;//Cada vez que terminas un hilo devuelves 1 a maximoCroquetas
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			break;
	    case "pollo":
			try {
				Thread.sleep(6000);
				System.out.println("Croqueta pollo "+num+" terminada");
				Procesadora.maximoCroquetas++;
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			break;
	    case "bacalao":
			try {
				Thread.sleep(7000);
				System.out.println("Croqueta bacalao "+num+" terminada");
				Procesadora.maximoCroquetas++;
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			break;
	    case "queso":
			try {
				Thread.sleep(8000);
				System.out.println("Croqueta queso "+num+" terminada");
				Procesadora.maximoCroquetas++;
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			break;
	}
	}
	
	public void run() {
		hacerCroquetas();
	}
}
