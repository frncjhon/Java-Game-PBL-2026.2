package Model; // Informa a qual grupo o arquivo pertence.
public class Estadodejogo {

    // Status do protagonista
    public double sanidade;
    public double lideranca;
    public double confianca;
    // Afinidade com os NPCs
    public double afinidadenpc1;
    public double afinidadenpc2;

    // Construtor
    public Estadodejogo() {
        // Valores iniciais do estado de jogo
        sanidade = 10;
        lideranca = 0;
        confianca = 0;
        afinidadenpc1 = 0;
        afinidadenpc2 = 0;
    }

    // Métodos para Status do Protagonista
    public void AumentarSanidade(double valor) {    // Sanidade
        sanidade = sanidade + valor;
    }
    public void AumentarLideranca(double valor) {   // Liderança
        lideranca = lideranca + valor;
    }
    public void AumentarConfianca(double valor) {   // Confiança
        confianca = confianca + valor;
    }

    // Métodos para alterar afinidade com NPCs

    // Apesar do metodo se chamar AUMENTAR ele pode diminuir. Não foi pensado nessa possibilidade durante
    // o desenvolvimento incial, mas no entanto decidimos manter este nome.

    // NPC1
    public void AumentarAfinidadeNPC1(double valor) {
        afinidadenpc1 = afinidadenpc1 + valor;
    }
    // NPC2
    public void AumentarAfinidadeNPC2(double valor) {
        afinidadenpc2 = afinidadenpc2 + valor;
    }
}
// Fim
