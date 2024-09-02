public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João Silva");
        Cliente cliente2 = new Cliente("Maria Oliveira");

        Conta conta1 = new ContaCorrente("001", cliente1);
        Conta conta2 = new ContaPoupanca("002", cliente2);

        Banco banco = new Banco();
        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        conta1.depositar(1000);
        conta2.depositar(1500);

        conta1.transferir(200, conta2);

        banco.listarClientes();
    }
}
