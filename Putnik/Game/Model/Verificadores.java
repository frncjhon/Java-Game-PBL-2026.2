package Model;

public class Verificadores {
    private Estadodejogo estado;
    public Verificadores(Estadodejogo estado) {
        this.estado = estado;
    }
    public boolean VerificadorSanidade() {
        if (estado.sanidade > 0) {
            return true;
        } else {
            return false;
        }
    }
}