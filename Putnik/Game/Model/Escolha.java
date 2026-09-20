package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escolha {
    private String pergunta;
    private List<Opcao> opcoes;

    public Escolha(String pergunta) {
        this.pergunta = pergunta;
        this.opcoes = new ArrayList<>();
    }

    public Escolha adicionarOpcao(String texto, java.util.function.Consumer<Estadodejogo> efeito) {
        opcoes.add(new Opcao(texto, efeito));
        return this;
    }

    public Opcao exibirEscolha(Scanner scanner, Estadodejogo estado) {
        System.out.println("\n" + pergunta);

        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + " - " + opcoes.get(i).getTexto());
        }

        int selecionada = -1;

        while (selecionada < 1 || selecionada > opcoes.size()) {
            System.out.print("> ");

            try {
                selecionada = Integer.parseInt(scanner.nextLine().trim());

                if (selecionada < 1 || selecionada > opcoes.size()) {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        Opcao escolhida = opcoes.get(selecionada - 1);
        escolhida.aplicarEfeito(estado);

        return escolhida;
    }
}
