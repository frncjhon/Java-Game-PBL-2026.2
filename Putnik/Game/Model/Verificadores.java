package Model; // Informa a qual grupo o arquivo pertence.

// Inicializa os verificadores utilizando o estado atual do jogo para consultar os atributos do personagem.
public class Verificadores {
    private Estadodejogo estado;
    public Verificadores(Estadodejogo estado) {
        this.estado = estado;
    }
    // Verifica se a sanidade do jogador está acima de 0 e retorna o resultado.
    public boolean VerificadorSanidade(){
        if (estado.sanidade > 0) {
            return true;
        } else {
            return false;
        }
    }
}
// Fim
