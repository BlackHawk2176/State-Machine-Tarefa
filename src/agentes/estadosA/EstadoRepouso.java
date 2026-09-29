package agentes.estadosA;

import agentes.Agente;
import agentes.Estado;

public class EstadoRepouso implements Estado {
    private static final int LIMITE_TICKS = 3;
    private final Agente agente;
    private int contador;

    public EstadoRepouso(Agente agente) {
        this.agente = agente;
    }

    @Override
    public void entrada() {
        contador = 0;
        System.out.println("  >> [A] ENTRADA: Repouso (aguardando " + LIMITE_TICKS + " ticks)");
    }

    @Override
    public void executar() {
        contador++;
        System.out.println("  [A] Repouso executando... tick " + contador + "/" + LIMITE_TICKS);
        if (contador >= LIMITE_TICKS) {
            agente.transicionarPara(new EstadoBuscando(agente));
        }
    }

    @Override
    public void saida() {
        System.out.println("  << [A] SAÍDA: Repouso");
    }
}