/**
 * A classe ContaTerminal representa uma conta bancária com atributos básicos e métodos de acesso,
 * incluindo práticas de programação defensiva para garantir a integridade dos dados.
 */
public class ContaTerminalPOO {

    // Atributos da conta
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    /**
     * Construtor padrão: inicializa os atributos com valores padrão.
     */
    public ContaTerminalPOO() {
        this.numero = 0;
        this.agencia = "";
        this.nomeCliente = "";
        this.saldo = 0.0;
    }

    /**
     * Construtor parametrizado: inicializa os atributos com os valores fornecidos,
     * incluindo validação de entradas.
     * 
     * @param numero Número da conta
     * @param agencia Agência da conta
     * @param nomeCliente Nome do cliente
     * @param saldo Saldo inicial da conta
     */
    public ContaTerminalPOO(int numero, String agencia, String nomeCliente, double saldo) {
        setNumero(numero);
        setAgencia(agencia);
        setNomeCliente(nomeCliente);
        setSaldo(saldo);
    }

    // Getters e Setters com Programação Defensiva

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número da conta deve ser maior que zero.");
        }
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        if (agencia == null || agencia.trim().isEmpty()) {
            throw new IllegalArgumentException("A agência não pode ser nula ou vazia.");
        }
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio.");
        }
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo não pode ser negativo.");
        }
        this.saldo = saldo;
    }
}
