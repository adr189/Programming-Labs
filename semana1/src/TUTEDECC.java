import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TUTEDECC {
	public static void inverteLinhas (String fileIn, String fileOut) throws FileNotFoundException {
		try {
			File in = new File(fileIn);
			Scanner myReader = new Scanner(in);
			File out = new File(fileOut);
			PrintWriter writer = new PrintWriter(out);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				StringBuilder sb = new StringBuilder();
				sb.append(data);
				sb.reverse();
				writer.write(sb.toString() + "\n");
				writer.flush();
			}
			myReader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred with one of the files.");
			e.printStackTrace();
		}
	}

	public static void trocaLinhas (String fileIn, String fileOut) throws FileNotFoundException {
		try {
			File in = new File(fileIn);
			Scanner myReader = new Scanner(in);
			File out = new File(fileOut);
			PrintWriter writer = new PrintWriter(out);
			while (myReader.hasNextLine()) {
				String line1 = myReader.nextLine();
				if (myReader.hasNextLine()) {
					String line2 = myReader.nextLine();
					writer.write(line2 + "\n");
					writer.flush();
				}
				writer.write(line1 + "\n");
				writer.flush();
			}
			myReader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred with one of the files.");
			e.printStackTrace();
		}
	}

	public static void duplicaCarateres (String fileIn, String fileLetras, String fileOut) throws FileNotFoundException {
		try {
			File in = new File(fileIn);
			File letras = new File(fileLetras);
			Scanner myReader = new Scanner(in);
			Scanner myReader1 = new Scanner(letras);
			String listaLetras = myReader1.nextLine();
			myReader1.close();
			File out = new File(fileOut);
			PrintWriter writer = new PrintWriter(out);
			StringBuilder sb;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				sb = new StringBuilder();
				sb.append(data);
				for (int i = 0; i < sb.length(); i++) {
					for (int j = 0; j < listaLetras.length(); j++) {
						if (sb.charAt(i) == listaLetras.charAt(j)) {
							sb.insert(i, listaLetras.charAt(j));
							i++;
						}
					}
				}
				writer.write(sb.toString() + "\n");
				writer.flush();
			}
			myReader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred with one of the files.");
			e.printStackTrace();
		}
	}

	public static void cifraCeaser (String fileIn, String fileOut) throws FileNotFoundException {
		try {
			File in = new File(fileIn);
			Scanner myReader = new Scanner(in);
			File out = new File(fileOut);
			PrintWriter writer = new PrintWriter(out);
			int lineNumber = 1;
			while (myReader.hasNextLine()) {
				String line1 = myReader.nextLine();
				char[] lineChars = line1.toCharArray();
				for (int i = 0; i < lineChars.length; i++) {
					if (lineChars[i] != ' ') {
						lineChars[i] = (char) (lineChars[i] + lineNumber);  //d�vida
					}
				}
				writer.write(new String(lineChars).trim() + "\n");
				writer.flush();
				lineNumber++;
			}
			myReader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred with one of the files.");
			e.printStackTrace();
		}
	}

	public static void linhasMesmoComprimento (String fileIn, int n, String fileOut) throws FileNotFoundException {
		try {
			File in = new File(fileIn);
			Scanner myReader = new Scanner(in);
			File out = new File(fileOut);
			PrintWriter writer = new PrintWriter(out);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				for (int i = 0; i < line.length(); i+=n) {
					if (line.length() - i >= n)
						writer.write(line.substring(i, i + n) + "\n");
					else
						writer.write(line.substring(i, line.length()) + "\n");
					writer.flush();
				}
			}
			myReader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred with one of the files.");
			e.printStackTrace();
		}
	}

	public static void reflexosAlternados (String fileIn, int n, String fileOut) throws IOException {
		try {
			File in = new File(fileIn);
			Scanner myReader = new Scanner(in);
			File out = new File(fileOut);
			PrintWriter writer = new PrintWriter(out);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				for (int i = 0; i < line.length(); i+=n) {
					if (line.length() - i >= n)
						writer.write(line.substring(i, i + n) + "\n");
					else
						writer.write(line.substring(i, line.length()) + "\n");
					writer.flush();
				}
			}
			myReader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred with one of the files.");
			e.printStackTrace();
		}
	}

	public static void reflexosAlternados(String fileIn, int n, String fileOut) throws IOException{
		try {
			File in = new File(fileIn);													// Input File
			Scanner reader = new Scanner(in);											// Scanner to read input file

			File out = new File(fileOut);												// Output File
			PrintWriter writer = new PrintWriter(out);									// PrintWriter to write to output

			while (reader.hasNextLine()) {												// Loop through every line of input file
				String data = reader.nextLine();										// String to store the new line from input file

				int sliceSize = (int) Math.ceil((float)(data.length())/n);				// Calculate slice sizes

				String [] array = new String[n];										// String array to store the line splits

				for (int i = 0; i < n; i++) {											// For each position in the array (size n)
					if(i<n-1)															// If current position is not the last...
						array[i] = data.substring(i*sliceSize, (i+1)*sliceSize);		// We store at array[i] the respective substring of size sliceSize (same order as the input file)
					else																// If the current position is the last
						array[i] = data.substring(i*sliceSize, data.length());			// We just store the final string until the end (might not be of length==sliceSize)
				}
				for(int i = 0; i < n/2; i+=2) {											// This fore cycle goes in increments of 2 and only until i==n/2 (we change in pairs so half the iterations suffice)
					String temp = "";													// We must change the symmetric pairs - we store one in a temporary variable
					temp = array[i];													// -^
					array[i]=array[n-1-i];												// We put in the first one the contents of the second one
					array[n-1-i] = temp;												// And we store in the second one the contents of the first one
				}																		// IMPORTANT: i+=2 because we don't want to change them all but in yesNOyesNOyes manner...

				writer.write(String.join("", array)+"\n");								// Write the array contents (it stores the result of the line modifications)
				writer.flush();
			}
			reader.close();																// Reader and Writer close
			writer.close();
		} catch (IOException e) {														// Catch IOException (generic stuff). Not sure why this one is different from other methods...
			System.out.println("An error occurred with one of the files.");
			e.printStackTrace();
		}
	}
}
