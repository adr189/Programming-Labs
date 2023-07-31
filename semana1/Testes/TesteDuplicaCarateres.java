import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TesteDuplicaCarateres {

	@Test
	public void testDuplicaCarateres() throws IOException {
        String esperado = "oss prratoss e ass colherress \n" + "forram ah prraia nadarr\n";
        
        String texto = "os pratos e as colheres \n" + "foram ah praia nadar\n";
        String letras = "rs";
        
        PrintWriter in = new PrintWriter("input.txt");
        in.write(texto);
        in.close();
        
        PrintWriter let = new PrintWriter("letrasTeste.txt");
        let.write(letras);
        let.close();

        TUTEDECC.duplicaCarateres("input.txt", "letrasTeste.txt", "output.txt");

        String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);
       
        assertEquals(esperado, obtida);

        in.close();
	}

}
