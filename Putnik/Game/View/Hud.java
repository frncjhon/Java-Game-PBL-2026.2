package View; // Informa a qual grupo o arquivo pertence.
import java.util.Scanner;

public class Hud { // Inicializa o Hud, e configura a leitura das entradas do jogador.
    private Scanner scanner;
    public Hud(Scanner scanner) {
        this.scanner = scanner;
    }
    // Apenas Imprime, as opções de personalidade, e retorna a escolha.
    public int HudPersonalidade() {

        System.out.println();
        System.out.println("       Escolha a personalidade inicial do seu personagem.");
        System.out.println("╔══════════════════╗   ╔══════════════════╗   ╔══════════════════╗");
        System.out.println("║   CARISMÁTICO    ║   ║     CORAJOSO     ║   ║  PERFECCIONISTA  ║");
        System.out.println("╠══════════════════╣   ╠══════════════════╣   ╠══════════════════╣");
        System.out.println("║                  ║   ║                  ║   ║                  ║");
        System.out.println("║   Afinidade +6   ║   ║   Confiança +3   ║   ║   Liderança +6   ║");
        System.out.println("║                  ║   ║                  ║   ║                  ║");
        System.out.println("║       [ 1 ]      ║   ║       [ 2 ]      ║   ║       [ 3 ]      ║");
        System.out.println("║                  ║   ║                  ║   ║                  ║");
        System.out.println("╚══════════════════╝   ╚══════════════════╝   ╚══════════════════╝");
        System.out.println("~ Se prefererir uma experiência mais desafiadora, selecione qualquer N- ~");
        System.out.println("               ~ para começar com status em 0!~");
        System.out.println();
        System.out.print("Escolha sua característica: ");

        return scanner.nextInt();

    }
    // Utiliza as informações passada pelo controlador sobre o estadodejogo.java para imprimir os status.
    public void HudStatus(double confianca, double afinidadep1, double afinidadep2, double sanidade, double lideranca) {

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║          STATUS DO PERSONAGEM    ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ Confiança:      " + confianca);
        System.out.println("║ Afinidade Ibis: " + afinidadep1);
        System.out.println("║ Afinidade Deyv: " + afinidadep2);
        System.out.println("║ Liderança:      " + lideranca);
        System.out.println("║ Sanidade:       " + sanidade);
        System.out.println("╚══════════════════════════════════╝");

    }
    // Avisa ao jogador a forma de continuar o jogo.
    public void AvisoEnter(){
        System.out.println("\nAVISO: para continuar a narrativa, pressione ENTER após cada novo dialogo.\n");
    }
    // Apesar do nome, a verdadeira função desse metodo é imprimir 50 linhas vazias, para simular a limpeza.
    public void Limparterminal(){
        for (int i = 0; i < 50; i++)
            System.out.println();
    }
    // Mensagem de morte, caso a sanidade chegue a zero.
    public void MensagemMorte(){
        System.out.println("Oh não! Sua sanidade chegou a zero, e o Serj Enlouqueceu.");
    }
}
// Fim
