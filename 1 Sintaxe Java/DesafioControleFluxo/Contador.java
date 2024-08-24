package DesafioControleFluxo;

/**
 * A classe Contador é responsável por receber dois parâmetros via terminal e
 * realizar a contagem com base na diferença entre eles. Inclui uma exceção
 * customizada para validar os parâmetros de entrada.
 */
public class Contador {

    // Classe interna para a exceção personalizada
    static class ParametrosInvalidosException extends Exception {
        public ParametrosInvalidosException(String mensagem) {
            super(mensagem);
        }
    }

    public static void main(String[] args) {
        try {
            // Verifica se os parâmetros foram fornecidos
            if (args.length < 2) {
                throw new IllegalArgumentException("Dois parâmetros devem ser fornecidos.");
            }

            // Tenta converter os parâmetros para inteiros
            int parametroUm = Integer.parseInt(args[0]);
            int parametroDois = Integer.parseInt(args[1]);

            // Verifica se o primeiro parâmetro é menor que o segundo
            if (parametroUm >= parametroDois) {
                throw new ParametrosInvalidosException("O primeiro parâmetro deve ser menor que o segundo parâmetro.");
            }

            // Calcula a quantidade de iterações
            int iteracoes = parametroDois - parametroUm;

            // Executa o loop de contagem
            for (int i = 1; i <= iteracoes; i++) {
                System.out.println("Loop: " + i);
            }

        } catch (ParametrosInvalidosException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Os parâmetros devem ser números inteiros.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

