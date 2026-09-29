package agentes.estadosB;

import agentes.Agente;
import agentes.Estado;

public class EstadoAlerta implements Estado {
    private static final int LIMITE_TICKS = 3;
    private final Agente agente;
    private int contador;

    public EstadoAlerta(Agente agente) {
        this.agente = agente;
    }

    @Override
    public void entrada() {
        contador = 0;
        System.out.println("  >> [B] ENTRADA: Alerta (limite " + LIMITE_TICKS + " ticks)");
    }

    @Override
    public void executar() {
        contador++;
        System.out.println("  [B] Em ALERTA! tick " + contador + "/" + LIMITE_TICKS);
        if (contador >= LIMITE_TICKS) {
            agente.transicionarPara(new EstadoPatrulhando(agente));
        }
    }

    @Override
    public void saida() {
        System.out.println("  << [B] SAIDA: Alerta");
    }
}