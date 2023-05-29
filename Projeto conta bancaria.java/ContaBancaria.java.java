import java.util.Scanner;

class ContaBancaria {
    private String nome;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String nome, int numeroConta, double saldo) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Conta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da Pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Número da Conta: ");
        int numeroConta = scanner.nextInt();

        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso.");

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Depositar valor");
            System.out.println("2. Sacar valor");
            System.out.println("3. Obter saldo disponível");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saldo disponível: R$ " + conta.getSaldo());
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
