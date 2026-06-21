package modelo;

public class Apartamento extends Financiamento{

    private int vagaGaragem;
    private int numeroAndar;

    public Apartamento(String tipo, double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagaGaragem, int numeroAndar) {
        super(tipo, valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagaGaragem = vagaGaragem;
        this.numeroAndar = numeroAndar;
    }

    public double calcularTotalPagamento(){
        return (valorImovel) * (1 + (taxaJurosAnual * prazoFinanciamento));
    }

    public double calcularPagamentoMensal() {
        return (calcularTotalPagamento()) / (prazoFinanciamento * 12);
    }

    public void imprimirResultado(){
        super.imprimirResultado();
        System.out.println("Vagas de garagem: " + vagaGaragem);
        System.out.println("Numero do andar: " + numeroAndar);

        /* Realizamos override para subscreever o metodo imprimir resultado, chamamos o super para char o metodo da classe pai
         * E posterior adicionamos as informações que serão acionadas apenas nessa clase*/
    }
}
