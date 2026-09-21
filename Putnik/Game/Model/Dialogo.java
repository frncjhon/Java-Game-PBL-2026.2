package Model; // Informa a qual grupo o arquivo pertence.

public class Dialogo {
    private String personagem;
    private String texto;

    // Inicializa um diálogo apenas com o texto.
    public Dialogo(String texto) {
        this.texto = texto;
    }
    // Inicializa um diálogo definindo o personagem e o texto da fala.
    public Dialogo(String personagem, String texto) {
        this.personagem = personagem;
        this.texto = texto;
    }
    // Exibe
    public void exibir() {
        if (personagem != null) {
            System.out.println(personagem + ": " + texto);
        } else {
            System.out.println(texto);
        }
    }
}
// Fim
