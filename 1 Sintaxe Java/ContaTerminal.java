import java.util.Scanner;

/**
 * A classe ContaTerminal é responsável por coletar informações de uma conta bancária
 * via terminal e exibir uma mensagem de confirmação com os dados fornecidos.
 */
public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar informações da conta ao usuário
        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Por favor, digite o número da Conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        System.out.print("Por favor, digite o nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Por favor, digite o saldo inicial: ");
        double saldo = scanner.nextDouble();

        // Exibir mensagem de confirmação
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, " +
                           "sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo " + 
                           String.format("%.2f", saldo) + " já está disponível para saque.");

        scanner.close();
    }
}
