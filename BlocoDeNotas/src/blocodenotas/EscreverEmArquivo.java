package BlocoDeNotas;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class EscreverEmArquivo {

	public static void main(String[] args) {
        
		Path caminho = Paths.get("C:/CES-22/nome.txt");
        String texto = JOptionPane.showInputDialog("Nota");
        byte[] textoEmByte = texto.getBytes();
        try{
        	Files.write(caminho,  textoEmByte);
        }catch(Exception erro){
        	
        }
        
    }
}
