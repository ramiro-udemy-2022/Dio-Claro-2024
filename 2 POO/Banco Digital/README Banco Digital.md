# Bootcamp Claro + Dio : Java Springboot

Este é um projeto criado para o bootcamp "Java Springboot", organizado pela **Claro Brasil** e a escola **DIO**.

## 🛠️ Capitulo 2 - POO
- 🤖 Projeto : Banco Digital.

### Dominio. 
- Um banco oferece aos seus clientes dois tipos de contas : corrente e poupança.
Esses tipos de contas possuem as funcionalidades : depósito, saque e transferência.

### Produto.
- Conta: Classe abstrata com métodos comuns para ContaCorrente e ContaPoupanca.
- ContaCorrente e ContaPoupanca: Classes que herdam de Conta.
- Cliente: Classe que representa o cliente.
- Banco: Classe que gerencia as contas e clientes.

### Diagrama de classes
O diagrama representa a relação entre as classes e os métodos que cada uma delas possui. A relação de composição entre Conta e Cliente indica que cada conta está associada a um cliente, e a composição entre Banco e Conta mostra que o banco gerencia várias contas.

```
@startuml Banc_Digital

class Conta {
    -String numero
    -double saldo
    -Cliente cliente
    --
    +Conta(String numero, Cliente cliente)
    +String getNumero()
    +double getSaldo()
    +Cliente getCliente()
    +void depositar(double valor)
    +void sacar(double valor)
    +void transferir(double valor, Conta contaDestino)
}

class ContaCorrente {
}

class ContaPoupanca {
}

class Cliente {
    -String nome
    --
    +Cliente(String nome)
    +String getNome()
}

class Banco {
    -List<Conta> contas
    --
    +Banco()
    +void adicionarConta(Conta conta)
    +void listarClientes()
    +Conta encontrarContaPorNumero(String numero)
}

Conta <|-- ContaCorrente
Conta <|-- ContaPoupanca
Conta *-- Cliente
Banco *-- Conta

@enduml

```


<p align="center">
<img 
    src="/assets/Banco_Digital.png"
    width="500"
/>
</p>

#### Classe Conta
 
- Classe abstrata que define os métodos comuns para ContaCorrente e ContaPoupanca.

```java
public abstract class Conta {
    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente.");
        }
    }
}

```
#### Classe ContaCorrente e ContaPoupanca
 
- Classes que herdam de Conta.

```java
public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, Cliente cliente) {
        super(numero, cliente);
    }
}

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, Cliente cliente) {
        super(numero, cliente);
    }
}

```

#### Classe Cliente
 
- Representa o cliente com um atributo nome.

```java
public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

```

#### Classe Banco
 
- Gerencia as contas dos clientes e fornece um método para listar todas as contas com seus saldos.

```java
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

```

#### Classe Main
 
- Classe para executar o programa e demonstrar a funcionalidade.

```java
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

```

## 👨‍💻 Expert

<p>
    <img 
      align=left 
      margin=10 
      width=80 
      src="/assets/Avatar_Ramiro.jpeg"
    />
    <p>&nbsp&nbsp&nbspRamiro Zavala<br>
    &nbsp&nbsp&nbsp
    <a 
        href="https://github.com/ramiro-ebac-2022/">
        GitHub
    </a>
    &nbsp;|&nbsp;
    <a 
        href="https://www.linkedin.com/in/ramiro-arce/">
        LinkedIn
    </a>
    &nbsp;|&nbsp;
</p>
</p>
<br/><br/>
<p>