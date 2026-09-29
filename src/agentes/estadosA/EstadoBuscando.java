package agentes.estadosA;

import agentes.Agente;
import agentes.Estado;

public class EstadoBuscando implements Estado {
    private static final int LIMITE_TICKS = 4;
    private final Agente agente;
    private int contador;

    public EstadoBuscando(Agente agente) {
        this.agente = agente;
    }

    @Override
    public void entrada() {
        contador = 0;
        System.out.println("  >> [A] ENTRADA: Buscando (limite " + LIMITE_TICKS + " ticks)");
    }

    @Override
    public void executar() {
        contador++;
        System.out.println("  [A] Buscando alvo... tick " + contador + "/" + LIMITE_TICKS);
        if (contador >= LIMITE_TICKS) {
            agente.transicionarPara(new EstadoAtacando(agente));
        }
    }

    @Override
    public void saida() {
        System.out.println("  << [A] SAÍDA: Buscando");
    }
}