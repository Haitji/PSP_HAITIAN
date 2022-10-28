package AP2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class crearProcesoSuma {
	public static void main(String[] args) throws IOException {
		try {
			String clase = "AP2.Suma";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			ProcessBuilder builder = new ProcessBuilder(command);
			Process p = builder.inheritIO().start();
			p.waitFor();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
