public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipoConta = scanner.nextInt();

        Conta conta = null;

        if (tipoConta == 1) {
            conta = new ContaCorrente(nomeTitular);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(nomeTitular);
        } else {
            System.out.println("Tipo de conta inválido!");
            return;
        }

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            if (conta instanceof ContaPoupanca) {
                System.out.println("3 - Calcular Rendimento");
            }
            System.out.println("4 - Exibir Dados da Conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta instanceof ContaCorrente) {
                        ((ContaCorrente) conta).sacar(valorSaque);
                    } else {
                        ((ContaPoupanca) conta).sacar(valorSaque);
                    }
                    break;
                case 3:
                    if (conta instanceof ContaPoupanca) {
                        System.out.print("Digite a taxa Selic: ");
                        double selic = scanner.nextDouble();
                        ((ContaPoupanca) conta).calcularRendimento(selic);
                    } else {
                        System.out.println("Opção indisponível para Conta Corrente.");
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
