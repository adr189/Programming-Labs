
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TesteInverteLinhas {

    @Test
    public void testInverteLinhas () throws IOException {

        String esperado = ",aselgni edadisrevinu amu ed asiuqsep amu moc odroca ed" +"\n" +
                          ".arvalap amu ed sartel sa oatse medro euq me atropmi oan" + "\n";
        
        String texto = "de acordo com uma pesquisa de uma universidade inglesa," + "\n" +
                       "nao importa em que ordem estao as letras de uma palavra." + "\n";
        
        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();

        TUTEDECC.inverteLinhas("input.txt", "output.txt");

        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);
       
        assertEquals(esperado, obtida);

        in.close();
        
    }    
  

}
