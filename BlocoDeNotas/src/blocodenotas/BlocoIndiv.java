package blocodenotas;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BlocoIndiv {
    private String NomeArq, NomeAnot;
    
    public void escrever(String texto, String metatag) {
        File diretório = new File("C:\\CES22\\"+this.NomeArq);
        File arq = new File(diretório, this.NomeAnot+".txt");

        try {
            arq.createNewFile();
 
            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            Date d = new Date();
            
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
             
            printWriter.println(formatador.format(d));
            
            printWriter.println(metatag);
            
            printWriter.println(texto);

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public BlocoIndiv(String NomeArq, String NomeAnot){
            this.NomeArq=NomeArq;
            this.NomeAnot=NomeAnot;
        }
    
}