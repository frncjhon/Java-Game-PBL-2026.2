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

    // Carrega a cena de uma vez
    public Capitulo(String titulo, Dialogo[] cena) {
        this.titulo = titulo;
        this.dialogos = new ArrayList<>(List.of(cena));
    }
    public void adicionarCena(Dialogo[] cena) {
        dialogos.addAll(List.of(cena));
    }
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
    private void pressEnter(){
        System.out.print("\n");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
