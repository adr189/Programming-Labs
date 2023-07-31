import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TesteEspelhoPartido {


    @Test
    public void testEspelhoPartido () throws IOException {

        String esperado = "emNatal oa naoelho da Pasce o Co existO Pai " + "\n";
        String texto = "O Pai Natal e o Coelho da Pascoa nao existem" + "\n";

        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();


        TUTEDECC.reflexosAlternados("input.txt", 8, "output.txt");

        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), 
                StandardCharsets.UTF_8);

        assertEquals(esperado, obtida);

    }
}
