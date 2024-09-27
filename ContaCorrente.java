class ContaCorrente extends Conta {
    private static final double CHEQUE_ESPECIAL = 1000.0;

    public ContaCorrente(String titular) {
        super(titular);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depositado: R$ %.2f%n", valor);
    }

    public void sacar(double valor) {
        if (valor <= saldo + CHEQUE_ESPECIAL) {
            saldo -= valor;
            System.out.printf("Sacado: R$ %.2f%n", valor);
        } else {
            System.out.println("Saldo insuficiente, incluindo cheque especial!");
        }
    }
}
