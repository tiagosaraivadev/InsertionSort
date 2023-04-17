import java.util.Scanner;
public class Aplicacao {
	
	
	public static void main(String[] args) {
		//Ler arquivo jogadores e armazenar em um vetor de objetos jogadores
		Scanner s = new Scanner(System.in);
		String entrada = "";
		int tamanhoArray = 5000;
		int id = 0;
		
		ArquivoTextoLeitura arqLeitura = new ArquivoTextoLeitura("src/jogadores.txt");
		Jogador[] jogadores = new Jogador[tamanhoArray];
		
		
		while (! entrada.equals("FIM")) {
			
			entrada = arqLeitura.ler();
			
			if (! entrada.equals("FIM")) {
				jogadores[id] = new Jogador(entrada);
				id++;
				
			}
		}
		
		
		//Lê os IDs de jogadores e armazena em um vetor de objetos jogadores a ser ordenado
		String novaEntrada = "";
		int tamArray = 500;
		int posicao = 0;
		Jogador[] novoJogador = new Jogador[tamArray];


		// Loop para ler vários IDs até encontrar a palavra "FIM"
		while (!novaEntrada.equals("FIM")) {
		    novaEntrada = s.nextLine();
		    if (!novaEntrada.equals("FIM")) {
		    	
		        // Busca o índice correspondente ao ID informado
		        for (int i = 0; i < id; i++) {
		            if (jogadores[i].getId() == Integer.parseInt(novaEntrada)) {
		                novoJogador[posicao] = jogadores[i];
		                novoJogador[posicao] = new Jogador(jogadores[i]);
		                posicao++;
		            }
		        }
		    }
		}
		
		// Ordena o vetor de jogadores pelo ano de nascimento e nome
		InsertionSort.sort(novoJogador);

		// Imprime os dados dos jogadores ordenados
		for (int i = 0; i < novoJogador.length; i++) {
		    if (novoJogador[i] != null) {
		        novoJogador[i].imprimeDados();
		    }
		}

		s.close();
}
}
