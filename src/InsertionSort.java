
public class InsertionSort {
	public static void sort(Jogador[] jogadores) {
        for (int i = 1; i < jogadores.length; i++) {
            Jogador chave = jogadores[i];
            int j = i - 1;
            while (j >= 0 && compararJogadores(jogadores[j], chave) > 0) {
                jogadores[j + 1] = jogadores[j];
                j--;
            }
            jogadores[j + 1] = chave;
        }
    }

    private static int compararJogadores(Jogador jogador1, Jogador jogador2) {
        if (jogador1 == null && jogador2 == null) {
            return 0;
        } else if (jogador1 == null) {
            return -1;
        } else if (jogador2 == null) {
            return 1;
        } else {
            int comparacaoAno = Integer.compare(jogador1.getAnoNascimento(), jogador2.getAnoNascimento());
            if (comparacaoAno != 0) {
                return comparacaoAno;
            } else {
                return jogador1.getNome().compareTo(jogador2.getNome());
            }
        }
    }
}