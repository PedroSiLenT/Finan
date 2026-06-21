package modelo;

public abstract class Financiamento {
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
   /* Metodo abstrato para que cada metodo seja implementado individualmente em cada subclasse */
   public abstract double calcularPagamentoMensal();

   public abstract double calcularTotalPagamento();

   public void imprimirResultado(){
       /* alteração feita, sem necessidade do switch neste caso  */
       System.out.println("Tipo: " + tipo);
       System.out.printf("O valor do imovel é: R$ %.2f%n", valorImovel);
       System.out.printf("Prazo: %d anos | Taxa anual: %.2f%%%n", prazoFinanciamento, taxaJurosAnual);
       System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
       System.out.printf("Total a ser pago: R$ %.2f%n", calcularTotalPagamento());
   }

}

