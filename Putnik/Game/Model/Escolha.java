package Model; // Informa a qual grupo o arquivo pertence.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Inicializa uma escolha com uma pergunta e uma lista vazia para armazenar suas opções.
public class Escolha {
    private String pergunta;
    private List<Opcao> opcoes;

    public Escolha(String pergunta) {
        this.pergunta = pergunta;
        this.opcoes = new ArrayList<>();
    }
    // Adiciona uma nova opção à escolha, definindo o texto e o efeito que será aplicado ao estado do jogo.
    public Escolha adicionarOpcao(String texto, java.util.function.Consumer<Estadodejogo> efeito) {
        opcoes.add(new Opcao(texto, efeito));
        return this;
    }
    // Exibe a pergunta da escolha para o jogador e prepara a seleção de uma opção.
    public Opcao exibirEscolha(Scanner scanner, Estadodejogo estado) {
        System.out.println("\n" + pergunta);
        // Percorre todas as opções e exibe cada uma numerada para o jogador.
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + " - " + opcoes.get(i).getTexto());
        }

        int selecionada = -1; // Inicializa a variável com -1 para indicar que nenhuma opção foi selecionada ainda.
        while (selecionada < 1 || selecionada > opcoes.size()) { // Repete a escolha.
            System.out.print("> ");

            // Tenta converter a entrada do jogador para número e
            // verifica se a opção está dentro das opções disponíveis.
            try {
                selecionada = Integer.parseInt(scanner.nextLine().trim());
                if (selecionada < 1 || selecionada > opcoes.size()) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        // Obtém a opção escolhida pelo jogador e aplica o efeito dela ao estado atual do jogo.
        Opcao escolhida = opcoes.get(selecionada - 1);
        escolhida.aplicarEfeito(estado);

        return escolhida; // Retorna
    }
}
// Fim
