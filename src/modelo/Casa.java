package modelo;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(String tipo, double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(tipo, valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    /*Fazendo um override sobreescrevendo o metodo do financiamento*/
    public double calcularPagamentoMensal() {
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12)) + 80;
    }

    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }

    public void imprimirResultado(){
        super.imprimirResultado();
        System.out.println("Area construida: " + areaConstruida + "m²");
        System.out.println("Tamanho terreno: " + tamanhoTerreno + "m²");

        /* Realizamos override para subscreever o metodo imprimir resultado, chamamos o super para char o metodo da classe pai
        * E posterior adicionamos as informações que serão acionadas apenas nessa clase*/
    }
}
