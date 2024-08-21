import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A classe ContaBanco é responsável por interagir com o usuário, coletar dados e
 * exibir uma mensagem de confirmação usando a classe ContaTerminal, com programação defensiva.
 */
public class ContaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar informações da conta ao usuário
            System.out.print("Por favor, digite o número da Agência: ");
            String agencia = scanner.nextLine().trim();

            System.out.print("Por favor, digite o número da Conta: ");
            int numeroConta = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            System.out.print("Por favor, digite o nome do Cliente: ");
            String nomeCliente = scanner.nextLine().trim();

            System.out.print("Por favor, digite o saldo inicial: ");
            double saldo = scanner.nextDouble();

            // Instanciar a classe ContaTerminal usando o construtor parametrizado com validação
            ContaTerminalPOO conta = new ContaTerminalPOO(numeroConta, agencia, nomeCliente, saldo);

            // Exibir mensagem de confirmação
            System.out.println("Olá " + conta.getNomeCliente() + ", obrigado por criar uma conta em nosso banco, " +
                            "sua agência é " + conta.getAgencia() + ", conta " + conta.getNumero() + 
                            " e seu saldo " + String.format("%.2f", conta.getSaldo()) + 
                            " já está disponível para saque.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira os dados corretamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
