package main;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario user = new InterfaceUsuario();
        Financiamento finan = user.coletarDados();
        finan.imprimirResultado();
    }
}
