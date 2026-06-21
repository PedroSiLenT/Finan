package modelo;

public class Terreno extends Financiamento{

    private String zona;

    public Terreno(String tipo, double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(tipo, valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    public double calcularPagamentoMensal() {
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12)) * 1.02;
    }

    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }

    public void imprimirResultado(){
        super.imprimirResultado();
        System.out.println("Zona do terreno: " + zona);

        /* Realizamos override para subscreever o metodo imprimir resultado, chamamos o super para char o metodo da classe pai
         * E posterior adicionamos as informações que serão acionadas apenas nessa clase*/
    }
}
