package Model;

import java.util.function.Consumer;

public class Opcao {
    private String texto;
    private Consumer<Estadodejogo> efeito;

    public Opcao(String texto, Consumer<Estadodejogo> efeito){
        this.texto = texto;
        this.efeito = efeito;
    }
    public String getTexto() {
        return texto;
    }
    public void aplicarEfeito(Estadodejogo estado){
        if (efeito != null){
            efeito.accept(estado);
        }
    }
}
