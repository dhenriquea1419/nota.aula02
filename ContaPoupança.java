class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular) {
        super(titular);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depositado: R$ %.2f%n", valor);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Sacado: R$ %.2f%n", valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void calcularRendimento(double selic) {
        double rendimento;
        if (selic > 8.5) {
            rendimento = 0.005 * saldo; 
        } else {
            rendimento = 0.007 * selic * saldo; 
        }
        saldo += rendimento;
        System.out.printf("Rendimento calculado: R$ %.2f%n", rendimento);
    }
}
