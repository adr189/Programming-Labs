
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TesteLinhasMesmoComprimento {

    @Test
    public void testLinhasMesmoComprimento () throws IOException {

        String esperado = "Agora es" + "\n" + "te texto" + "\n" +
        		" vai ser" + "\n" + " usado " + "\n" +
        		"para tes" + "\n" + "tar o me" + "\n" +
        		"todo que" + "\n" + " trunca " + "\n" +
        		"as linha" + "\n" + "s " + "\n" +
        		"para fic" + "\n" + "arem com" + "\n" +
        		" o mesmo" + "\n" + " comprim" + "\n" +
        		"ento" + "\n";
        
        String texto = "Agora este texto vai ser usado " + "\n" + 
                       "para testar o metodo que trunca as linhas " + "\n" +
        		           "para ficarem com o mesmo comprimento" + "\n";
        
        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();        

        TUTEDECC.linhasMesmoComprimento("input.txt", 8, "output.txt");

        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), 
                StandardCharsets.UTF_8);

        assertEquals(esperado, obtida);

    }
 
}
