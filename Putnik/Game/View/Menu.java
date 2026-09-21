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

    public void ExibirInfo(){
        System.out.println("""
                
            ███████████  █████  █████ ███████████ ██████   █████ █████ █████   ████
            ▒▒███▒▒▒▒▒███▒▒███  ▒▒███ ▒█▒▒▒███▒▒▒█▒▒██████ ▒▒███ ▒▒███ ▒▒███   ███▒ 
             ▒███    ▒███ ▒███   ▒███ ▒   ▒███  ▒  ▒███▒███ ▒███  ▒███  ▒███  ███   
             ▒██████████  ▒███   ▒███     ▒███     ▒███▒▒███▒███  ▒███  ▒███████    
             ▒███▒▒▒▒▒▒   ▒███   ▒███     ▒███     ▒███ ▒▒██████  ▒███  ▒███▒▒███   
             ▒███         ▒███   ▒███     ▒███     ▒███  ▒▒█████  ▒███  ▒███ ▒▒███  
             █████        ▒▒████████      █████    █████  ▒▒█████ █████ █████ ▒▒████
            ▒▒▒▒▒          ▒▒▒▒▒▒▒▒      ▒▒▒▒▒    ▒▒▒▒▒    ▒▒▒▒▒ ▒▒▒▒▒ ▒▒▒▒▒   ▒▒▒▒
                
                Serj é um jovem fascinado por estéticas distintas, livros de
                H.P. Lovecraft, casos inexplicáveis e lendas da internet.
                Porém, tudo muda na madrugada de 20 de Maio de 2006, quando
                acorda e percebe que não está mais em sua casa, mas entre os
                destroços do que parece ser um prédio abandonado. Ao se
                levantar, percebe algo ainda mais estranho: não há qualquer
                som de seres vivos naquele lugar, nem mesmo de animais. Após
                conseguir sair dos destroços, Serj encontra Ibis, um conhecido
                de sua infância. Nenhum dos dois sabe como ou por que foram
                parar naquele lugar e, sem respostas, decidem seguir juntos
                em busca da verdade. Entretanto, conforme avançam, começam a
                descobrir que aquele lugar esconde algo muito maior e mais
                sombrio do que poderiam imaginar. Entre mistérios, escolhas,
                sacrifícios e acontecimentos que desafiam a própria realidade,
                Serj precisará descobrir até onde está disposto a ir para
                sobreviver e descobrir a verdade.
                
                Criado por Jhony França & Cleuber Coelho
            """);

    }
}
