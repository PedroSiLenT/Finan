package util;
import modelo.Financiamento;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public Financiamento coletarDados(){
        double valorImovel = 0;
        int prazo = 0;
        double taxa = 0;
        String tipo = "";
        do {
            try {
                System.out.println("Digite o tipo do imovel: Casa/Apartamento/Terreno: ");
                tipo = scanner.nextLine();

                System.out.println("Digite o valor do imóvel: R$");
                valorImovel = scanner.nextDouble();
                if(valorImovel <=0) {
                    System.out.println("Valor inserido incorreto! Digite um valor positivo!");
                    continue;
                }
                System.out.println("Digite o prazo do financiamento (Em anos):");
                prazo = scanner.nextInt();
                if(prazo <= 0) {
                    System.out.println("Valor inserido incorreto! Digite um valor positivo!");
                    continue;
                }
                System.out.println("Digite a taxa de Juros Anual");
                taxa = scanner.nextDouble();
                if(taxa < 0 || taxa > 60) {
                    System.out.println("Valor inserido incorreto! Digite um valor positivo!");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite apenas numeros!");
                scanner.next();
            }
        } while (tipo == "" || valorImovel <= 0  || prazo <= 0 || taxa <= 0);



        return new Financiamento(tipo, valorImovel, prazo, taxa); // Aqui instanciamento a classe financiamento e passamos os valores para o construtor
    }
}
