package agentes;

public class Agente {
    private final String nome;
    private Estado estado;
    private int ticksTotais;

    public Agente(String nome) {
        this.nome = nome;
    }

    public void iniciar(Estado estadoInicial) {
        this.estado = estadoInicial;
        System.out.println("[" + nome + "] inicializado no estado "
                + estadoInicial.getClass().getSimpleName());
        estado.entrada();
    }

    public void transicionarPara(Estado novoEstado) {
        System.out.println("[" + nome + "] TRANSIÇÃO: "
                + estado.getClass().getSimpleName() + " -> "
                + novoEstado.getClass().getSimpleName());
        estado.saida();
        this.estado = novoEstado;
        novoEstado.entrada();
    }

    public void tick() {
        ticksTotais++;
        estado.executar();
    }

    public String getNome()   { return nome; }
    public Estado getEstado() { return estado; }
    public int getTicksTotais() { return ticksTotais; }
}