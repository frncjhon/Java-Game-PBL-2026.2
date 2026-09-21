package View; // Informa a qual grupo o arquivo pertence.
import Model.Dialogo;

// Cria e retorna um capítulo com TITULO e DIALOGO informado.
public class ConstrutorCapitulo {
    public static Capitulo criarCena(String titulo, Dialogo[] cena){
        return new Capitulo(titulo,cena);
    }
}
// Fim
