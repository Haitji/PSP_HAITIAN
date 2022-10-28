package AP2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class reader {

	public static void main(String[] args) throws IOException {
		
		String currentLine;
		try {
		     BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		     while((currentLine = reader.readLine()) != null) {
			     System.out.print(currentLine+"\n");
		     }

		     reader.close();

	     }catch (FileNotFoundException e){
	    	 System.err.println("Error al leer.");
	     }

	}

}
