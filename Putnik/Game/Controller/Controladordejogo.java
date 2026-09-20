package Controller;

// Importação para trabalhar com o View e o Model do projeto.
import Model.*;
import View.*;

import java.util.Scanner;

public class Controladordejogo {


//Declarações
    private Estadodejogo estado;
    private Menu menu;
    private Introducao introducao;
    private Hud hud;
    private Scanner scanner;

// Criação das instâncias
    public Controladordejogo() {
        estado = new Estadodejogo();
        menu = new Menu();
        introducao = new Introducao();
        hud = new Hud();
        scanner = new Scanner(System.in);
    }


    // Inicia o Menu, e fica responsável por fazer todo o inicio do jogo.
    public void iniciarJogo() {
        boolean executando = true;

        while (executando) {

            int menuopcao = menu.ExibirMenu();

            if (menuopcao == 1) { // Se a escolha for iniciar, o contexto é apresentado
                                  // Junto com a escolha de personalidade.
                hud.Limparterminal();
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
                hud.Limparterminal();
                // Passa como parametros a informação que está no Estadodejogo.java
                hud.HudStatus(
                        estado.confianca, estado.afinidadenpc1, estado.afinidadenpc2, estado.sanidade, estado.lideranca);
                hud.AvisoEnter();

                // Inicia o capitulo

                // CAPÍTULO 1
                Capitulo cena1 = ConstrutorCapitulo.criarCena("Cena 1 - O DESPERTAR", RepDialogo.cap1cen1);
                cena1.exibirCapitulo();
                Escolha escolha1 = new Escolha("Investigar?")
                        .adicionarOpcao("Sim", estadodejogo -> estado.AumentarConfianca(1))
                        .adicionarOpcao("Não", estadodejogo -> estado.AumentarSanidade(-3));


                Opcao resultado = escolha1.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                hud.HudStatus(estado.confianca, estado.afinidadenpc1, estado.afinidadenpc2, estado.sanidade, estado.lideranca);
                Capitulo cena2 = ConstrutorCapitulo.criarCena("Cena 2 - O SILÊNCIO", RepDialogo.cap1cen2);
                cena2.exibirCapitulo();
                Capitulo cena3 = ConstrutorCapitulo.criarCena("Cena 3 - O PRIMEIRO REGISTRO", RepDialogo.cap1cen3);
                cena3.exibirCapitulo();
                Capitulo cena4 = ConstrutorCapitulo.criarCena("Cena 4 - TRÊS CAMINHOS", RepDialogo.cap1cen4);
                cena4.exibirCapitulo();

                hud.Limparterminal();
                // CAPÍTULO 2
                Capitulo cena5 = ConstrutorCapitulo.criarCena("Cena 1 - A CIDADE SEM CÉU", RepDialogo.cap2cen1);
                cena5.exibirCapitulo();
                Capitulo cena6 = ConstrutorCapitulo.criarCena("Cena 2 - O HOMEM DA JANELA", RepDialogo.cap2cen2);
                cena6.exibirCapitulo();
                Capitulo cena7 = ConstrutorCapitulo.criarCena("Cena 3 - A REGRA DO ECO", RepDialogo.cap2cen3);
                cena7.exibirCapitulo();
                Capitulo cena8 = ConstrutorCapitulo.criarCena("Cena 4 - O SINAL", RepDialogo.cap2cen4);
                cena8.exibirCapitulo();

                hud.Limparterminal();
                // CAPÍTULO 3
                Capitulo cena9 = ConstrutorCapitulo.criarCena("Cena 1 - A ESTAÇÃO", RepDialogo.cap3cen1);
                cena9.exibirCapitulo();
                Capitulo cena10 = ConstrutorCapitulo.criarCena("Cena 2 - MEMÓRIAS QUE NÃO PERTENCEM", RepDialogo.cap3cen2);
                cena10.exibirCapitulo();
                Capitulo cena11 = ConstrutorCapitulo.criarCena("Cena 3 - O NOME ESCRITO", RepDialogo.cap3cen3);
                cena11.exibirCapitulo();
                Capitulo cena12 = ConstrutorCapitulo.criarCena("Cena 4 - A FALSA SAÍDA", RepDialogo.cap3cen4);
                cena12.exibirCapitulo();

                hud.Limparterminal();
                // CAPÍTULO 4
                Capitulo cena13 = ConstrutorCapitulo.criarCena("Cena 1 - A CASA DE BAIXO", RepDialogo.cap4cen1);
                cena13.exibirCapitulo();
                Capitulo cena14 = ConstrutorCapitulo.criarCena("Cena 2 - O PREÇO", RepDialogo.cap4cen2);
                cena14.exibirCapitulo();
                Capitulo cena15 = ConstrutorCapitulo.criarCena("Cena 3 - A VERDADE DE DEYV", RepDialogo.cap4cen3);
                cena15.exibirCapitulo();
                Capitulo cena16 = ConstrutorCapitulo.criarCena("Cena 4 - O RELÓGIO", RepDialogo.cap4cen4);
                cena16.exibirCapitulo();


                hud.Limparterminal();
                // CAPÍTULO 5
                Capitulo cena17 = ConstrutorCapitulo.criarCena("Cena 1 - A PRISÃO UNIVERSAL", RepDialogo.cap5cen1);
                cena17.exibirCapitulo();
                Capitulo cena18 = ConstrutorCapitulo.criarCena("Cena 2 - O CENTRO", RepDialogo.cap5cen2);
                cena18.exibirCapitulo();
                Capitulo cena19 = ConstrutorCapitulo.criarCena("Cena 3 - A ESCOLHA", RepDialogo.cap5cen3);
                cena19.exibirCapitulo();
                Capitulo cena20 = ConstrutorCapitulo.criarCena("Cena 4 - O ÚLTIMO PASSAGEIRO", RepDialogo.cap5cen4);
                cena20.exibirCapitulo();}


            // "Fecha" o jogo
            hud.Limparterminal();
            if (menuopcao == 2) {
                System.out.println(" Fechando o Jogo...");
                System.out.println("(Obrigado por jogar)");

                executando = false;
            }
        }
    }
}
