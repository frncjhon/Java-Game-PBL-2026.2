package Model;

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

    // Sanidade
    public void AumentarSanidade(double valor) {
        sanidade = sanidade + valor;
    }

    // Liderança
    public void AumentarLideranca(double valor) {
        lideranca = lideranca + valor;
    }
    // Confiança
    public void AumentarConfianca(double valor) {
        confianca = confianca + valor;
    }

// Métodos para alterar afinidade com NPCs
    // NPC1
    public void AumentarAfinidadeNPC1(double valor) {
        afinidadenpc1 = afinidadenpc1 + valor;
    }

    // NPC2
    public void AumentarAfinidadeNPC2(double valor) {
        afinidadenpc2 = afinidadenpc2 + valor;
    }

}
