import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class LOCCounter {

	/**
	 * @param args
	 */
	static int totalLines;
	static boolean showCode;
	String nameOfFile;
	ArrayList<String> finalFile;

	
	public static void main(String[] args) {
		if (args.length == 0)
			System.out.println("USAGE: ");
		if (args[0].equals("-p"))
			showCode = true;
		int i;
		if (showCode){
			i = 1;
		}
		else i=0;
		totalLines = 0;
		for (; i < args.length; i++) {
			LOCCounter loc = new LOCCounter();
			loc.finalFile = new ArrayList<String>();
			
			File file = new File("./src/" + args[i]);
			loc.ReadFile(file);
			loc.PrintFile();
		}
		System.out.println("Total: " + totalLines);
	}


}
