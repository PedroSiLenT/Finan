package modelo;

public class Financiamento {
    protected String tipo;
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

   public Financiamento(String tipo, double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.tipo = tipo;
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
   }
   public double calcularPagamentoMensal() {
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
   }

   public double calcularTotalPagamento(){
       return calcularPagamentoMensal() * (prazoFinanciamento * 12);
   }

   public void imprimirResultado(){
       /* alteração feita, sem necessidade do switch neste caso  */
       System.out.println("Tipo: " + tipo);
       System.out.printf("O valor do imovel é: R$ %.2f%n", valorImovel);
       System.out.printf("Prazo: %d anos | Taxa anual: %.2f%%%n", prazoFinanciamento, taxaJurosAnual);
       System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
       System.out.printf("Total a ser pago: R$ %.2f%n", calcularTotalPagamento());
   }

}

