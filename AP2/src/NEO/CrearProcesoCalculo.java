package NEO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrearProcesoCalculo {
	public void CrearProcesoCalculo() {
		
	}
	public Process p;
	public void crearProceso(double posicion,double velocidad,String nombre) {
		try {
			String clase = "NEO.calculos";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(String.valueOf(posicion));
			command.add(String.valueOf(velocidad));
			command.add(nombre);
			ProcessBuilder builder = new ProcessBuilder(command);
			try {
				p = builder.inheritIO().start();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> leer() throws IOException{
		List<String> contenido=new ArrayList<String>();
		String currentLine;
		try {
		     BufferedReader reader = new BufferedReader(new FileReader("astros.txt"));
		     try {
			     while((currentLine = reader.readLine()) != null) {
				    contenido.add(currentLine);
			     }
		     }catch(FileNotFoundException e) {
		    	 System.out.println("Error al guardar linea");
		     }
		     reader.close();
	     }catch (FileNotFoundException e){
	    	 System.err.println("Error al leer.");
	     }
		return contenido;
	}
	public double getResultado(String FResultado) throws IOException
	{
		double res=0;
		FileReader reader;
		try {
			reader = new FileReader(FResultado);
			BufferedReader br = new BufferedReader(reader);
			
			String result= br.readLine();
			res=Double.valueOf(result);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/*
	 * public static void main(String[] args) throws IOException { try {
	 * List<String> a= leer(); for(int i=0;i<a.size();i++) { String[] b=
	 * a.get(i).split(","); System.out.println(b[2]); } }catch(Exception e){
	 * System.out.println("Error al ejecutar"); } }
	 */
	
}
