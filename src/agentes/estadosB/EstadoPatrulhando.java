package agentes.estadosB;

import agentes.Agente;
import agentes.Estado;

public class EstadoPatrulhando implements Estado {
    private static final int LIMITE_TICKS = 5;
    private final Agente agente;
    private int contador;

    public EstadoPatrulhando(Agente agente) {
        this.agente = agente;
    }

    @Override
    public void entrada() {
        contador = 0;
        System.out.println("  >> [B] ENTRADA: Patrulhando (limite " + LIMITE_TICKS + " ticks)");
    }

    @Override
    public void executar() {
        contador++;
        System.out.println("  [B] Patrulhando área... tick " + contador + "/" + LIMITE_TICKS);
        if (contador >= LIMITE_TICKS) {
            agente.transicionarPara(new EstadoAlerta(agente));
        }
    }

    @Override
    public void saida() {
        System.out.println("  << [B] SAÍDA: Patrulhando");
    }
}