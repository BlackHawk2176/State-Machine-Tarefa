package agentes.estadosA;

import agentes.Agente;
import agentes.Estado;

public class EstadoAtacando implements Estado {
    private static final int LIMITE_TICKS = 2;
    private final Agente agente;
    private int contador;

    public EstadoAtacando(Agente agente) {
        this.agente = agente;
    }

    @Override
    public void entrada() {
        contador = 0;
        System.out.println("  >> [A] ENTRADA: Atacando (limite " + LIMITE_TICKS + " ticks)");
    }

    @Override
    public void executar() {
        contador++;
        System.out.println("  [A] Atacando alvo! tick " + contador + "/" + LIMITE_TICKS);
        if (contador >= LIMITE_TICKS) {
            agente.transicionarPara(new EstadoRepouso(agente));
        }
    }

    @Override
    public void saida() {
        System.out.println("  << [A] SAÍDA: Atacando");
    }
}