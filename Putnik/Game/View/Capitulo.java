package View; // Informa a qual grupo o arquivo pertence.

// Importa as classes necessárias para trabalhar com dialogos e listas de objetos.
import Model.Dialogo;
import java.util.ArrayList;
import java.util.List;

// Inicializa um capitulo com seu TITULO e uma LISTA vazia de dialogos.
public class Capitulo {
    private String titulo;
    private List<Dialogo> dialogos;

    public Capitulo(String titulo, Dialogo[] cena) {
        this.titulo = titulo;
        this.dialogos = new ArrayList<>(List.of(cena));
    }
    // Adiciona todos os diálogos de uma cena à lista do capítulo.
    public void adicionarCena(Dialogo[] cena) {
        dialogos.addAll(List.of(cena));
    }
    // Adiciona um único diálogo à lista do capítulo.
    public void adicionarDialogo(Dialogo dialogo) {
        dialogos.add(dialogo);
    }

    public void exibirCapitulo(){
        System.out.println(""+ titulo +"\n");
        for (Dialogo d : dialogos){
            d.exibir();
            pressEnter();
        }
    }
    // Aguarda o jogador pressionar Enter para continuar a execução do jogo.
    private void pressEnter(){
        System.out.print("\n");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// Fim
