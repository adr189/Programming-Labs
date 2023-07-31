import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({  
				TesteInverteLinhas.class,
				TesteTrocaLinhas.class,
				TesteDuplicaCarateres.class,
				TesteCifraCeaser.class,
				TesteLinhasMesmoComprimento.class,
				TesteEspelhoPartido.class
				})

public class AllTests {

}