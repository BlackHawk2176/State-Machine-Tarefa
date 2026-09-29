package agentes;

import agentes.estadosA.EstadoRepouso;
import agentes.estadosB.EstadoPatrulhando;

public class Gerenciador {
    private static final int MAX_TICKS = 25;
    private static final long INTERVALO_MS = 400;

    public static void main(String[] args) {
        Agente agenteA = new Agente("Agente A");
        agenteA.iniciar(new EstadoRepouso(agenteA));

        Agente agenteB = new Agente("Agente B");
        agenteB.iniciar(new EstadoPatrulhando(agenteB));

        for (int tick = 1; tick <= MAX_TICKS; tick++) {
            System.out.println("\n========== TICK " + tick + " ==========");
            agenteA.tick();
            agenteB.tick();
            pausar(INTERVALO_MS);
        }
        System.out.println("\nSimulação encerrada após " + MAX_TICKS + " ticks.");
    }

    private static void pausar(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}