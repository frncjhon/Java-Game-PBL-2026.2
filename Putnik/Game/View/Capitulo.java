package View;

import Model.Dialogo;
import java.util.ArrayList;
import java.util.List;

public class Capitulo {
    private String titulo;
    private List<Dialogo> dialogos;

    public Capitulo(String titulo) {
        this.titulo = titulo;
        this.dialogos = new ArrayList<>();
    }

    public void addDialogo(Dialogo dialogo){
        this.dialogos.add(dialogo);
    }

    public void exibirCapitulo(){
        System.out.println(""+ titulo +"\n");
        for (Dialogo d : dialogos){
            d.exibir();
            pressEnter();
        }
    }
    private void pressEnter(){
        System.out.print("\nPressione ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
