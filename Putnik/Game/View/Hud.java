package View;
import java.util.Scanner;


public class Hud {

    private Scanner scanner;
    public Hud(Scanner scanner) {
        this.scanner = scanner;
    }

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

    public void AvisoEnter(){
        System.out.println("\nAVISO: para continuar a narrativa, pressione ENTER após cada novo dialogo.\n");
    }

    public void Limparterminal(){
        for (int i = 0; i < 50; i++)
            System.out.println();
    }
    public void MensagemMorte(){
        System.out.println("Oh não! Sua sanidade chegou a zero, e o Serj Enlouqueceu.");
    }
}
