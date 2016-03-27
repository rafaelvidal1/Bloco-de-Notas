package blocodenotas;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BlocoDeNotas {

    public static void main(String[] args) {
        
        String Nome,caminho,texto;
        int Opcao;
        boolean verif;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.printf("Digite seu nome para verificação: ");
        Nome=entrada.nextLine();
        
        caminho ="C:/Users/Pará/Documents/ITA/5ºSemestre/CES-22 (Yano)/Trabalho 01/BlocoDeNotas/"+Nome+".txt";
        
        File arquivo = new File(caminho);
        
        if(!arquivo.exists()){
             BlocoIndiv novoBloco = new BlocoIndiv(Nome);
             System.out.println("Digite sua anotação: ");
             texto=entrada.nextLine();
             novoBloco.escrever(texto);
        }
        
        else{
            Opcao=Menu(entrada);
            
            if(Opcao==0){
                verif=true;
                editar(arquivo,verif);
            }
            if(Opcao==1){
                System.out.println("Suas anotações foram apagadas!!");
                verif=false;
                editar(arquivo,verif);
            }
            if(Opcao==2){
                salvar(arquivo);
                System.out.println("Salvo!!");
            }    
        }
    }
    
    public static void editar(File arq, boolean verif) {
        Scanner novaEntr = new Scanner(System.in);    
        String novaAnot;
        
        System.out.println("Digite a nova anotação: ");
        novaAnot=novaEntr.nextLine();
        
        try {
            arq.createNewFile();
 
            FileWriter fileWriter = new FileWriter(arq, verif);

            PrintWriter printWriter = new PrintWriter(fileWriter,verif);

            Locale locale = new Locale("pt","BR");
            GregorianCalendar calendar = new GregorianCalendar(); 
            SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
            
            printWriter.println("\n\n");
            
            printWriter.println(formatador.format(calendar.getTime()));
            
            printWriter.println("Anotação : " + novaAnot);

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static int Menu(Scanner entrada){
        int Op;
        
        System.out.println("\tMenu de opções Bloco de Notas: ");
        System.out.println("0. Editar");
        System.out.println("1. Apagar");
        System.out.println("2. Salvar");
        Op=entrada.nextInt();
        
        return Op;
    }
    
    public static void salvar(File arq){
        FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter(arq);
        } catch (IOException ex) {
            Logger.getLogger(BlocoDeNotas.class.getName()).log(Level.SEVERE, null, ex);
        }

        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        try {
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(BlocoDeNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        printWriter.close();
        
    }
        
    
}