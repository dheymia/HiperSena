package senac.hipersena.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Sorte {

    private int jogadas;
    private int casas;
    private List<Aposta> apostas;

    public Sorte(int jogadas, int casas) throws Exception {
        this.jogadas = jogadas;
        this.casas = casas;
        validarApostas();
    }

    private void validarApostas() throws Exception {
        if (!validarJogadas()) {
            throw new Exception("Escolha entre 1 a 100 jogadas!");
        } else if (!validarCasas()) {
            throw new Exception("Escolha entre 6 a 15 casas!");
        }
    }

    public List<Aposta> gerarApostas() {

        validarJogadas();

        apostas = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i <= jogadas; i++) {

            Set<Integer> numeros = new TreeSet<>();

            for (int j = 1; j <= casas; j++) {
                while (true) {
                    if (numeros.add(random.nextInt(59) + 1)) {
                        break;
                    }
                }
            }

            apostas.add(new Aposta(numeros.toString()));
        }

        return apostas;
    }

    private boolean validarJogadas() {
        if (jogadas < 1 || jogadas > 100) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validarCasas() {
        if (casas < 6 || casas > 15) {
            return false;
        } else {
            return true;
        }
    }

    public int getJogadas() {
        return jogadas;
    }

    public int getCasas() {
        return casas;
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

}
