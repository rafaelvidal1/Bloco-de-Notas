package blocodenotas;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;


public class BlocoDeNotas {

    public static void main(String[] args) {
        
        String Nome,caminho,texto,palavraAntiga,palavraNova;
        int Opcao;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.printf("Digite seu nome para verificação: ");
        Nome=entrada.nextLine();
        
        caminho ="C:/Users/Pará/Documents/ITA/5ºSemestre/CES-22 (Yano)/Trabalho 01/BlocoDeNotas/"+Nome+".txt";
        
        File arquivo = new File(caminho);
        
        if(arquivo.exists()){
            Opcao=Menu(entrada);
            
            if(Opcao==0){
                System.out.println("Digite a palavra que quer editar: ");
                palavraAntiga=entrada.nextLine();
                
                System.out.println("Digite a nova palavra que quer escrever no lugar de "+palavraAntiga+" :");
                palavraNova=entrada.nextLine();
                Editar(Nome,palavraAntiga,palavraNova);
            }
            if(Opcao==1)
                System.out.println("TESTE");
            if(Opcao==2)
                System.out.println("TESTE");    
        }
        
        else{
             BlocoIndiv novoBloco = new BlocoIndiv(Nome);
             System.out.println("Digite sua anotação: ");
             texto=entrada.nextLine();
             novoBloco.escrever(texto);
        }
    }
    
    public static void Editar(String Nome,String palavraAntiga, String palavraNova){
        
        String arquivo = Nome + ".txt" ;
        String arquivoTmp = "ARQUIVO-tmp";
        String linha;
        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
        }catch(IOException erro){
            System.err.println("Erro");
        }
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        }catch(FileNotFoundException erro){
            System.err.println("Erro");
        }

        while ((linha = reader.readLine()) != null) {
            if (linha.contains(palavraAntiga)) {
                linha = linha.replace(palavraAntiga, palavraNova);
            }
            writer.write(linha + "\n");
        }

        writer.close();        
        reader.close();

        new File(arquivo).delete();
        new File(arquivoTmp).renameTo(new File(arquivo));      
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
        
    
}