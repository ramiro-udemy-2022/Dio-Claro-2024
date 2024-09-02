import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarClientes() {
        for (Conta conta : contas) {
            System.out.println("Nome: " + conta.getCliente().getNome() +
                    ", Conta: " + conta.getNumero() +
                    ", Saldo: " + conta.getSaldo());
        }
    }

    public Conta encontrarContaPorNumero(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }
}
