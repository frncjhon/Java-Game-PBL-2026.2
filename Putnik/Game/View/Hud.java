package View;
import java.util.Scanner;


public class Hud {
    Scanner scanner = new Scanner(System.in);
    public int HudPersonalidade() {
        System.out.println();
        System.out.println("╔══════════════════╗   ╔══════════════════╗   ╔══════════════════╗");
        System.out.println("║   CARISMÁTICO    ║   ║     CORAJOSO     ║   ║  PERFECCIONISTA  ║");
        System.out.println("╠══════════════════╣   ╠══════════════════╣   ╠══════════════════╣");
        System.out.println("║                  ║   ║                  ║   ║                  ║");
        System.out.println("║   Afinidade +6   ║   ║   Confiança +3   ║   ║   Liderança +6   ║");
        System.out.println("║                  ║   ║                  ║   ║                  ║");
        System.out.println("║       [ 1 ]      ║   ║       [ 2 ]      ║   ║       [ 3 ]      ║");
        System.out.println("║                  ║   ║                  ║   ║                  ║");
        System.out.println("╚══════════════════╝   ╚══════════════════╝   ╚══════════════════╝");
        System.out.println();
        System.out.print("Escolha sua característica: ");
        return scanner.nextInt();
    }
    public void HudStatus(double confianca, double afinidadep1, double afinidadep2, double sanidade, double lideranca) {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║          STATUS DO PERSONAGEM    ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ Confiança:       " + confianca);
        System.out.println("║ Afinidade P1:    " + afinidadep1);
        System.out.println("║ Afinidade P2:    " + afinidadep2);
        System.out.println("║ Liderança:        " + lideranca);
        System.out.println("║ Sanidade:        " + sanidade);
        System.out.println("╚══════════════════════════════════╝");
        }
    }

