package View;

import Model.Dialogo;
import Model.Estadodejogo;

public class ConstrutorCapitulo {
    public static Capitulo criarCapitulo(Estadodejogo estadodejogo) {
        Capitulo capitulo = new Capitulo("Cap 1");

        capitulo.addDialogo(new Dialogo("Narrador","Teste"));
    return capitulo;
    }
}
