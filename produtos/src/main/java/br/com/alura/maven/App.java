package br.com.alura.maven;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Produto produto = new Produto("bala", 0.15);
        System.out.println("nome do produto: " + produto.getNome() + " com o preço: " + produto.getPreco());
    }
}
