package modelo;

public class Financiamento {
    private String tipo;
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    /* TAXA DE JUROS */

    private double taxaCasa = 240.0;
    private double taxaTerreno = 1.02;

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

   public double parcelaCasa() {
       return calcularPagamentoMensal() + 240;
   }

   public double totalCasa() {
       return parcelaCasa() * (prazoFinanciamento * 12);
   }

   public double totalAp() {
       return (valorImovel) * (1 + (taxaJurosAnual * prazoFinanciamento));
   }

   public double parcelaAp() {
     return (totalAp()) / (prazoFinanciamento * 12);
   }

   public double parcelaTerreno() {
       return calcularPagamentoMensal() * 1.02;
   }

   public double totalTerreno() {
       return parcelaTerreno() * (prazoFinanciamento * 12);
   }

   public void imprimirResultado(){
       switch (tipo) {
           case "casa":
               System.out.printf("O valor do imovel é: R$ %.2f%n", valorImovel);
               System.out.printf("Prazo: %d anos | Taxa anual: %.2f%%%n", prazoFinanciamento, taxaJurosAnual);
               System.out.printf("Pagamento Mensal: R$ %.2f%n", parcelaCasa());
               System.out.printf("Total a ser pago: R$ %.2f%n", totalCasa());
               break;
           case "apartamento":
               System.out.printf("O valor do imovel é: R$ %.2f%n", valorImovel);
               System.out.printf("Prazo: %d anos | Taxa anual: %.2f%%%n", prazoFinanciamento, taxaJurosAnual);
               System.out.printf("Pagamento Mensal: R$ %.2f%n", parcelaAp());
               System.out.printf("Total a ser pago: R$ %.2f%n", totalAp());
               break;
           case "terreno":
               System.out.printf("O valor do imovel é: R$ %.2f%n", valorImovel);
               System.out.printf("Prazo: %d anos | Taxa anual: %.2f%%%n", prazoFinanciamento, taxaJurosAnual);
               System.out.printf("Pagamento Mensal: R$ %.2f%n", parcelaTerreno());
               System.out.printf("Total a ser pago: R$ %.2f%n", totalTerreno());
               break;
       }
   }

}

