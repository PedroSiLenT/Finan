package util;
import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public Financiamento coletarDados(){
        double valorImovel = 0;
        int prazo = 0;
        double taxa = 0;
        String tipo = "";

        double areaConstruida = 0;
        double tamanhoTerreno = 0;
        int vagaGaragem = 0;
        int numeroAndar = 0;
        String zona = "";
        do {
            try {
                System.out.println("Digite o tipo do imovel: Casa/Apartamento/Terreno: ");
                tipo = scanner.nextLine();

                switch (tipo) {
                    case "casa":
                        System.out.println("Digite a área construida: ");
                        areaConstruida = scanner.nextDouble();
                        System.out.println("Digite o tamanho do terreno: ");
                        tamanhoTerreno = scanner.nextDouble();
                        break;
                    case "apartamento":
                        System.out.println("Digite o numero de vagas: ");
                        vagaGaragem = scanner.nextInt();
                        System.out.println("Digite o numero do andar: ");
                        numeroAndar = scanner.nextInt();
                        break;
                    case "terreno":
                        System.out.println("Digite a zona do terreno Residencial/Comercial");
                        zona = scanner.nextLine();
                        break;
                }

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



        return switch (tipo.toLowerCase()) {
            case "casa" -> new Casa(tipo, valorImovel, prazo, taxa, areaConstruida, tamanhoTerreno);
            case "apartamento" -> new Apartamento(tipo, valorImovel, prazo, taxa, vagaGaragem, numeroAndar);
            case "terreno" -> new Terreno(tipo, valorImovel, prazo, taxa, zona);
            default -> throw new IllegalArgumentException("Tipo inválido: " + tipo);

            /*Switch necessario para instanciar cada classe em cada condição inserida: casa, ap, terreno*/
        };
    }
}
