package Model; // Informa a qual grupo o arquivo pertence.
import java.util.function.Consumer;

// Define uma opção com um texto e um efeito que pode modificar o estado do jogo quando executado.
public class Opcao {
    private String texto;
    private Consumer<Estadodejogo> efeito;

    // Inicializa uma opção recebendo o texto que será exibido e o efeito que será executado ao escolhê-la.
    public Opcao(String texto, Consumer<Estadodejogo> efeito){
        this.texto = texto;
        this.efeito = efeito;
    } // Retorna o texto da opção para ser exibido ao jogador.
    public String getTexto() {
        return texto;
    } // Verifica se existe um efeito e, caso exista, aplica esse efeito ao estado atual do jogo.
    public void aplicarEfeito(Estadodejogo estado){
        if (efeito != null){
            efeito.accept(estado);
        }
    }
}
// Fim
