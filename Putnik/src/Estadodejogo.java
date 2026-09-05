public class Estadodejogo{
    public double afinidadenpc1;
    public double afinidadenpc2;
    public double sanidade;
    public double lideranca;
    public double confianca;
// Declaração

    public Estadodejogo(){
        afinidadenpc1 = 0;
        afinidadenpc2 = 0;
        sanidade = 0;
        lideranca = 0;
        confianca = 0;
    } // Valores iniciais de estado de jogo.



    // Status do protagonista
    public void AumentarSanidade(double valor){
        sanidade = sanidade + valor;
    } // Metodo para alterar a sanidade do protagonista

    public void AumentarLideranca(double valor){
        lideranca = lideranca + valor;
    } // Metodo para alterar a lideranca do protagonista

    public void AumentarConfianca(double valor){
        confianca = confianca + valor;
    } // Metodo para alterar a confianca do protagonista



    public void AumentarAfinidadeNPC1(double valor){
        afinidadenpc1 = afinidadenpc1 + valor;
    } // Metodo para alterar a afinidade com o NPC1


    public void AumentarAfinidadeNPC2(double valor){
        afinidadenpc2 = afinidadenpc2 + valor;
    } // Metodo para alterar a afinidade com o NPC2



}
