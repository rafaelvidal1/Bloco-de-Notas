package blocodenotas;

import java.io.IOException;
import java.io.File;
import java.util.NoSuchElementException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BlocoIndiv {
    private String Nome;
    
    public void escrever(String texto) {
        File diretório = new File("C:/Users/Pará/Documents/ITA/5ºSemestre/CES-22 (Yano)/Trabalho 01/BlocoDeNotas");
        File arq = new File(diretório, this.Nome+".txt");

        try {
            arq.createNewFile();
 
            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(texto);

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public BlocoIndiv(String Nome){
            this.Nome=Nome;
        }
    
}
