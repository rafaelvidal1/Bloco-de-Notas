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
        File diretorio = new File("C:/CES22");
        File arq = new File(diretorio, this.Nome+".txt");

        try {
            arq.createNewFile();
 
            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            Locale locale = new Locale("pt","BR");
            GregorianCalendar calendar = new GregorianCalendar(); 
            SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
            
            printWriter.println("\n\n");
            
            printWriter.println(formatador.format(calendar.getTime()));
            
            printWriter.println("Anota��o : " + texto);

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
