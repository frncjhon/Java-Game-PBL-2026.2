package View;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
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
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }
}