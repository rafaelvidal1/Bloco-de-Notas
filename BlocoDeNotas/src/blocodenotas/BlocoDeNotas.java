package blocodenotas;

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.File;


public class BlocoDeNotas {

    public static void main(String[] args) {
        
        String Nome,Opcao,caminho;
        Scanner entrada = new Scanner(System.in);
        
        System.out.printf("Digite seu nome para verificação: ");
        Nome=entrada.nextLine();
        
        caminho = "C:/Users/Pará/Documents/ITA/5ºSemestre/CES-22 (Yano)/Trabalho 01/BlocoDeNotas/" +Nome+ ".txt";
        
        File arquivo = new File(caminho);
        
        if(arquivo.exists()){
            System.out.println("Arquivo existe! Quer editar (S/N) ?");
            Opcao=entrada.nextLine();
                
        }
        
        else{
             Path blocoDenotas = Paths.get(caminho);
             escrever(entrada,blocoDenotas);
        }
    }
    
    public static void escrever(Scanner entrada, Path blocoDenotas){
        String texto;
        byte[] textoEmByte;
        
        System.out.println("Digite o texto: ");
        texto=entrada.nextLine();
        
        textoEmByte=texto.getBytes();
        
        try{
            Files.write(blocoDenotas,textoEmByte);
        }catch(IOException erro){
            System.err.println("Erro!!");
        }
        
        
    }
        
    
}