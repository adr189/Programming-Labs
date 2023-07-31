import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TesteCifraCeaser {


    @Test
    public void testCifraCeaser () throws IOException {

        String esperado = "wbnpt wfs rvf sftvmubep" + "\n" + 
        		              "fctcj guvg vgzvq ekhtcfq" + "\n";

        String texto = "vamos ver que resultado " + "\n" + "darah este texto cifrado";

        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();

        TUTEDECC.cifraCeaser("input.txt", "output.txt");

        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), 
                StandardCharsets.UTF_8);

        assertEquals(esperado, obtida);

    }
}
