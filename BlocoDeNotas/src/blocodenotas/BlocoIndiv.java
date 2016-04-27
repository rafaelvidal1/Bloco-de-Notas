<<<<<<< HEAD
package blocodenotas;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BlocoIndiv {
    private String Nome;
    
    public void escrever(String texto) {
        File diretório = new File("C:/Users/Pará/Documents/ITA/5ºSemestre/CES-22 (Yano)/Trabalho 01/BlocoDeNotas");
        File arq = new File(diretório, this.Nome+".txt");

        try {
            arq.createNewFile();
 
            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            Locale locale = new Locale("pt","BR");
            GregorianCalendar calendar = new GregorianCalendar(); 
            SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);

            printWriter.println(formatador.format(calendar.getTime()));
            
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
=======
package blocodenotas;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BlocoIndiv {
    private String Nome;
    
    public void escrever(String texto) {
        File diretório = new File("C:/Lab1");
        File arq = new File(diretório, this.Nome+".txt");

        try {
            arq.createNewFile();
 
            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            Locale locale = new Locale("pt","BR");
            GregorianCalendar calendar = new GregorianCalendar(); 
            SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
            
            printWriter.println("\n\n");
            
            printWriter.println(formatador.format(calendar.getTime()));
            
            printWriter.println("Anotação : " + texto);

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
>>>>>>> origin/master
