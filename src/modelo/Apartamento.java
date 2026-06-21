package modelo;

public class Apartamento extends Financiamento{
    public Apartamento(String tipo, double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(tipo, valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double calcularTotalPagamento(){
        return (valorImovel) * (1 + (taxaJurosAnual * prazoFinanciamento));
    }

    public double calcularPagamentoMensal() {
        return (calcularTotalPagamento()) / (prazoFinanciamento * 12);
    }
}
