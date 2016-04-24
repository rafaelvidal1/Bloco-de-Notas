package blocodenotas;

import java.io.File;
import java.util.Scanner;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class LendoMétodos
{
    private String Nome;
    private Scanner entrada;
    
    public LendoMétodos(String Nome){
        this.Nome=Nome;
    }
    
    
    public void abrir()
    {
        System.out.println("Nome no editar: " +this.Nome);
        try
        {
            entrada = new Scanner( new File("C:/Users/Pará/Documents/ITA/5ºSemestre/CES-22 (Yano)/Trabalho 01/BlocoDeNotas/"+Nome+".txt") );
        }
        catch(FileNotFoundException arquivoNaoEncontrado)
        {
            System.err.println("Nao foi possível abrir o arquivo! Não encontrado!");
            System.exit(1); //saída de erro
        }
    }
 
    public void ler()
    {
        try
        {
            while( entrada.hasNext() )          
                System.out.printf("%s - %d\n",entrada.next(), entrada.nextInt());
        }
        catch(NoSuchElementException entradaDiferente)
        {
            System.err.println("Entrada diferente da esperada");
            entrada.close();
            System.exit(1);
        }
        catch(IllegalStateException erroLeitura)
        {
            System.err.println("Erro de leitura. Scanner foi fechada antes da input");
            System.exit(1);
        }
    }
 
    public void fechar()
    {
        entrada.close();
    }
}
