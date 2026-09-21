package View;
import Model.Dialogo;
import Model.RepDialogo;

public class ConstrutorCapitulo {
    public static Capitulo criarCena(String titulo, Dialogo[] cena){
        return new Capitulo(titulo,cena);
    }
}
