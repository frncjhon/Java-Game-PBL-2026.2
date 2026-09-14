package Model;

import java.security.PrivateKey;

public class Dialogo {
    private String personagem;
    private String texto;

    public Dialogo(String personagem, String texto) {
        this.personagem = personagem;
        this.texto = texto;
    }

    public void exibir(){
        System.out.println(personagem + ": " +  texto);
    }
}
