import java.util.Scanner;

class Conta {
    String titular;
    double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void exibirDados() {
        System.out.printf("Titular: %s%nSaldo: R$ %.2f%n", titular, saldo);
    }
}
