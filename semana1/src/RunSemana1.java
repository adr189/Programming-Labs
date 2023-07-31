import java.io.IOException;
/**
 * Classe de teste do projeto 1 referente ah TUTEDECC.
 * @author Team LabP
 */
public class RunSemana1 {

    public static void main (String[] args) throws IOException {

       /* Testar inverteLinhas: 
    	    * - copia as linhas do ficheiro de nome Texto1.txt para o
		*   ficheiro de nome linhasInvertidas.txt, invertendo-as
    	    * - copia as linhas do ficheiro de nome texto.txt para o
		*   ficheiro de nome out1.txt, invertendo-as
		*/
        TUTEDECC.inverteLinhas("Texto1.txt", "linhasInvertidas.txt");
        TUTEDECC.inverteLinhas("texto.txt", "out1.txt");

       /* Testar trocaLinhas: 
        * - copiar as linhas do ficheiro de nome Texto1.txt para o
		*  ficheiro de nome linhasTrocadas.txt, trocando 
        *  as linhas duas a duas. Se o numero de linhas for impar, a 
        *  ultima fica na mesma;
        * - o mesmo para os ficheiros texto.txt e out2.txt
        */
        TUTEDECC.trocaLinhas("Texto1.txt", "linhasTrocadas.txt");
        TUTEDECC.trocaLinhas("texto.txt", "out2.txt");

       /* Testar duplicaCarateres: 
        * - copiar as linhas do ficheiro de nome Texto2.txt para o
		*  ficheiro de nome duplicado.txt, duplicando determinadas
        *  letras, contidas no ficheiro de nome Letras.txt
        * - o mesmo para os ficheiros texto.txt, Letras.txt e out3.txt
        */
        TUTEDECC.duplicaCarateres("Texto2.txt", "Letras.txt", "duplicado.txt");
        TUTEDECC.duplicaCarateres("texto.txt", "Letras.txt", "out3.txt");

       /* Testar cifraCeaser: 
        * - copiar as linhas do ficheiro de nome Texto2.txt para o
		*  ficheiro de nome cifraCeaser.txt, aplicando, linha a linha,
        *  um shift de um dado numero de posicoes a cada carater de 
        *  cada palavra da linha;
        * - o mesmo para os ficheiros texto.txt e out4.txt  
        */
        TUTEDECC.cifraCeaser("Texto2.txt", "cifraCeaser.txt");
        TUTEDECC.cifraCeaser("texto.txt", "out4.txt");

       /* Testar linhasMesmoComprimento: 
        * - copiar as linhas do ficheiro de nome Texto1.txt para o
		*  ficheiro de nome mesmoComp.txt, usando somente 7 carateres
        *  em cada linha;
        * - o mesmo para os ficheiros texto.txt e out5.txt  
        */
        TUTEDECC.linhasMesmoComprimento("Texto1.txt", 7, "mesmoComp.txt");
        TUTEDECC.linhasMesmoComprimento("texto.txt", 7, "out5.txt");
        
       /* Testar espelhoPartido: 
        * - copiar as linhas do ficheiro  de nome Texto2.txt para o
		*  ficheiro de nome espelho.txt, trocando alguns conjuntos de
        *  6 caracteres com os seus "reflexos";
        * - o mesmo para os ficheiros texto.txt e out6.txt e o valor 2   
        * - o mesmo para os ficheiros texto.txt e out7.txt e o valor 4   
        * - o mesmo para os ficheiros texto.txt e out8.txt e o valor 6   
        */
        TUTEDECC.reflexosAlternados("Texto2.txt", 6, "espelho.txt");
        TUTEDECC.reflexosAlternados("texto.txt", 2, "out6.txt");
        TUTEDECC.reflexosAlternados("texto.txt", 4, "out7.txt");
        TUTEDECC.reflexosAlternados("texto.txt", 6, "out8.txt");

    }
}