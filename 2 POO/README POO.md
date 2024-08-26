# Bootcamp Claro + Dio : Java Springboot

Este é um projeto criado para o bootcamp "Java Springboot", organizado pela **Claro Brasil** e a escola **DIO**.

## 🛠️ Capitulo
- 🤖 2. POO.

### Desafio 
- Com base no vídeo de lançamento do iPhone conforme, elabore em uma ferramenta de UML de sua preferência. A diagramação das classes e interfaces com a proposta de representar os papéis do iPhone de: Reprodutor Musical, Aparelho Telefônico e Navegador na Internet. Em seguida crie as classes e interfaces no formato de arquivos .java

### Proposta de solução

#### Diagrama de classes
Criar um diagrama de classes que atenda as seguintes funcionalidades do iPhone : 

1. Reprodutor_Musical
	1.1 TocarMusica
	1.2 PausarMusica
	1.3 SelecionarMusica
	1.4 CriaListaReproducao
2. Telefone
	2.1 Ligar
	2.2 Atender
	2.3 MensagemAudio
3. NavegadorInternet
	3.1 ExibirPagina
	3.2 AdicionarAba
	3.3 AtualizarPagina

<p align="center">
<img 
    src="Uml iPhone.png"
    width="500"
/>
</p>

#### Explicação

- Dispositivo: Classe abstrata representando características gerais de um dispositivo.
- Aplicativo: Classe abstrata que encapsula comportamentos comuns a qualquer aplicativo.
- Reprodutor_Musical: Implementa as funcionalidades relacionadas à reprodução de música.
- Telefone: Implementa funcionalidades de telefone.
- NavegadorInternet: Implementa funcionalidades relacionadas à navegação na internet.
- Musica: Representa uma música e é agregada pelo Reprodutor_Musical.
- Pagina: Representa uma página da web, que é composta pelo NavegadorInternet.
- Smartphone: A classe principal que agrupa os diferentes aplicativos e funcionalidades.

#### Programa em Java

```java
import java.util.ArrayList;
import java.util.List;

// Classe abstrata para representar um dispositivo
abstract class Dispositivo {
    protected String nome;
    protected String modelo;

    public Dispositivo(String nome, String modelo) {
        this.nome = nome;
        this.modelo = modelo;
    }

    public void ligar() {
        System.out.println(nome + " ligado.");
    }

    public void desligar() {
        System.out.println(nome + " desligado.");
    }
}

// Classe abstrata para representar um aplicativo
abstract class Aplicativo {
    protected String nome;
    protected String versao;

    public Aplicativo(String nome, String versao) {
        this.nome = nome;
        this.versao = versao;
    }

    public void abrir() {
        System.out.println(nome + " aberto.");
    }

    public void fechar() {
        System.out.println(nome + " fechado.");
    }
}

// Classe Musica representando a música
class Musica {
    private String titulo;
    private String artista;
    private int duracao; // duração em segundos

    public Musica(String titulo, String artista, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracao() {
        return duracao;
    }
}

// Classe Reprodutor_Musical implementando as funcionalidades de reprodução de música
class Reprodutor_Musical extends Aplicativo {
    private List<Musica> listaReproducao = new ArrayList<>();

    public Reprodutor_Musical(String nome, String versao) {
        super(nome, versao);
    }

    public void TocarMusica() {
        System.out.println("Música tocando.");
    }

    public void PausarMusica() {
        System.out.println("Música pausada.");
    }

    public void SelecionarMusica(Musica musica) {
        System.out.println("Música selecionada: " + musica.getTitulo());
    }

    public void CriaListaReproducao(List<Musica> lista) {
        this.listaReproducao = lista;
        System.out.println("Lista de reprodução criada com " + lista.size() + " músicas.");
    }
}

// Classe Pagina representando uma página da web
class Pagina {
    private String url;
    private String conteudo;

    public Pagina(String url, String conteudo) {
        this.url = url;
        this.conteudo = conteudo;
    }

    // Getters e Setters
    public String getUrl() {
        return url;
    }

    public String getConteudo() {
        return conteudo;
    }
}

// Classe NavegadorInternet implementando as funcionalidades de navegação
class NavegadorInternet extends Aplicativo {
    private List<Pagina> paginasAbertas = new ArrayList<>();

    public NavegadorInternet(String nome, String versao) {
        super(nome, versao);
    }

    public void ExibirPagina(String url) {
        System.out.println("Exibindo página: " + url);
    }

    public void AdicionarAba(String url) {
        Pagina novaPagina = new Pagina(url, "Conteúdo da página");
        paginasAbertas.add(novaPagina);
        System.out.println("Aba adicionada: " + url);
    }

    public void AtualizarPagina() {
        System.out.println("Página atualizada.");
    }
}

// Classe Telefone implementando as funcionalidades de um telefone
class Telefone extends Dispositivo {
    private String numero;

    public Telefone(String nome, String modelo, String numero) {
        super(nome, modelo);
        this.numero = numero;
    }

    public void Ligar(String destino) {
        System.out.println("Ligando para " + destino + "...");
    }

    public void Atender() {
        System.out.println("Chamada atendida.");
    }

    public void MensagemAudio(String mensagem) {
        System.out.println("Mensagem de áudio: " + mensagem);
    }
}

// Classe principal Smartphone que agrupa todos os aplicativos
class Smartphone extends Dispositivo {
    private List<Aplicativo> aplicativos = new ArrayList<>();

    public Smartphone(String nome, String modelo) {
        super(nome, modelo);
    }

    public void adicionarAplicativo(Aplicativo app) {
        aplicativos.add(app);
        System.out.println("Aplicativo " + app.nome + " adicionado ao smartphone.");
    }

    public void removerAplicativo(Aplicativo app) {
        aplicativos.remove(app);
        System.out.println("Aplicativo " + app.nome + " removido do smartphone.");
    }
}

// Classe de teste
public class Main {
    public static void main(String[] args) {
        // Criando um smartphone
        Smartphone meuSmartphone = new Smartphone("MeuSmartphone", "Modelo X");

        // Criando aplicativos
        Reprodutor_Musical reprodutor = new Reprodutor_Musical("Reprodutor Musical", "v1.0");
        NavegadorInternet navegador = new NavegadorInternet("Navegador Internet", "v2.1");
        Telefone telefone = new Telefone("Telefone", "Modelo T", "1234-5678");

        // Adicionando aplicativos ao smartphone
        meuSmartphone.adicionarAplicativo(reprodutor);
        meuSmartphone.adicionarAplicativo(navegador);

        // Usando o telefone diretamente (considerando que é parte do dispositivo)
        telefone.Ligar("9876-5432");

        // Usando o reprodutor musical
        Musica musica1 = new Musica("Música 1", "Artista 1", 210);
        reprodutor.SelecionarMusica(musica1);
        reprodutor.TocarMusica();
    }
}

```

## 👨‍💻 Expert

<p>
    <img 
      align=left 
      margin=10 
      width=80 
      src="Avatar_Ramiro.jpeg"
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