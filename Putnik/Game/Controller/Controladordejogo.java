package Controller;

// Importação para trabalhar com o View e o Model do projeto.
import Model.*;
import View.*;

public class Controladordejogo {


//Declarações
    private Estadodejogo estado;
    private Menu menu;
    private Introducao introducao;
    private Hud hud;


// Criação das instâncias
    public Controladordejogo() {
        estado = new Estadodejogo();
        menu = new Menu();
        introducao = new Introducao();
        hud = new Hud();
    }


    // Inicia o Menu, e fica responsável por fazer todo o inicio do jogo.
    public void iniciarJogo() {
        boolean executando = true;

        while (executando) {

            int menuopcao = menu.ExibirMenu();

            if (menuopcao == 1) { // Se a escolha for iniciar, o contexto é apresentado
                                  // Junto com a escolha de personalidade.
                introducao.Contexto();

                int personalidadeopcao = hud.HudPersonalidade();

                if (personalidadeopcao == 1) {
                    estado.AumentarAfinidadeNPC1(6);
                    estado.AumentarAfinidadeNPC2(6);
                }

                if (personalidadeopcao == 2) {
                    estado.AumentarConfianca(3);
                }

                if (personalidadeopcao == 3) {
                    estado.AumentarLideranca(6);
                }
                // Passa como parametros a informação que está no Estadodejogo.java
                hud.HudStatus(
                        estado.confianca, estado.afinidadenpc1, estado.afinidadenpc2, estado.sanidade, estado.lideranca);

                // Inicia o capitulo
                Capitulo cena1 = ConstrutorCapitulo.criarCena("Cena 1 - O Despertar", RepDialogo.cap1cen1);
                cena1.exibirCapitulo();
            }

            // "Fecha" o jogo
            if (menuopcao == 2) {
                System.out.println(" Fechando o Jogo...");
                System.out.println("(Obrigado por jogar)");

                executando = false;
            }
        }
    }
}