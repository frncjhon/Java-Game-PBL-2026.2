package Model;

import java.security.PrivateKey;

public class Dialogo {
    private String personagem;
    private String texto;


    public Dialogo(String texto) {
        this.texto = texto;
    }
    public Dialogo(String personagem, String texto) {
        this.personagem = personagem;
        this.texto = texto;
    }

    public void exibir() {
        if (personagem != null) {
            System.out.println(personagem + ": " + texto);
        } else {
            System.out.println(texto);
        }
    }
}
