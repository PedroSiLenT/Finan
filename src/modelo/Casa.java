package modelo;

public class Casa extends Financiamento {
    public Casa(String tipo, double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(tipo, valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    /*Fazendo um override sobreescrevendo o metodo do financiamento*/
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() + 80;
    }

    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }
}
