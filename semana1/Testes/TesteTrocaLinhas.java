import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TesteTrocaLinhas {


    @Test
    public void testTrocaLinhas () throws IOException {

        String esperado = " tem 4 linhas" + "\n" + "Este texto" + "\n" + 
        		              " o metodo trocaLinhas" + "\n" + " e serve para testar" + "\n";


        String texto = "Este texto" + "\n" + " tem 4 linhas" + "\n" +
	                   " e serve para testar" + "\n" + " o metodo trocaLinhas" + "\n";

        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();
       
        TUTEDECC.trocaLinhas("input.txt", "output.txt");

        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);

        assertEquals(esperado, obtida);


    }


 
}
