package Auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Interface {
	// Debug flag, default = false
	boolean debug = false;

	public Interface() {}

	
	public Interface(boolean debug_) {
		debug = debug_;
	}

	
	public boolean loadFromFile(String filename, LinkedList<Double> number_list) {
		// Open file
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// Unable to load file
			if (debug)
				System.out.println("File " + filename + " not found.");
			return false;
		}

		// Read numbers while not EOF
		String line = "";
		do {
			try {
				line = file.readLine();
				if (line == null)
					break; // EOF
				String[] numeros = line.split("\\,");
				if (numeros.length < 2) System.out.println("ERRO");
				Double numero1 = Double.parseDouble(numeros[0]);
				Double numero2 = Double.parseDouble(numeros[1]);
				number_list.addNode(numero1, numero2);
			} catch (IOException e) {
				if (debug)
					System.out.println("Error while reading file " + filename + ".");
				return false;
			} catch (NumberFormatException e) {
				// Not number correct format, ignore
				if (debug)
					System.out.println("Error on parsing double value: " + e.getMessage());
			}
		} while (line != null);
		return true;
	}
}
