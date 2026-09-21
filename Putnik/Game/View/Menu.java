package View;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }    
    
    public int ExibirMenu() {

        System.out.println("""
         ███████████  █████  █████ ███████████ ██████   █████ █████ █████   ████
        ▒▒███▒▒▒▒▒███▒▒███  ▒▒███ ▒█▒▒▒███▒▒▒█▒▒██████ ▒▒███ ▒▒███ ▒▒███   ███▒ 
         ▒███    ▒███ ▒███   ▒███ ▒   ▒███  ▒  ▒███▒███ ▒███  ▒███  ▒███  ███   
         ▒██████████  ▒███   ▒███     ▒███     ▒███▒▒███▒███  ▒███  ▒███████    
         ▒███▒▒▒▒▒▒   ▒███   ▒███     ▒███     ▒███ ▒▒██████  ▒███  ▒███▒▒███   
         ▒███         ▒███   ▒███     ▒███     ▒███  ▒▒█████  ▒███  ▒███ ▒▒███  
         █████        ▒▒████████      █████    █████  ▒▒█████ █████ █████ ▒▒████
        ▒▒▒▒▒          ▒▒▒▒▒▒▒▒      ▒▒▒▒▒    ▒▒▒▒▒    ▒▒▒▒▒ ▒▒▒▒▒ ▒▒▒▒▒   ▒▒▒▒
        """);

        System.out.println("    [1] JOGAR");
        System.out.println("    [2] SAIR");
        System.out.println("    [3] INFORMAÇõES");
        System.out.print("Escolha uma opção: ");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida!");
                scanner.next();
                continue;
            }
            int opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 3) {
                return opcao;
            }
            System.out.println("Opção inválida!");
        }
    }
}
