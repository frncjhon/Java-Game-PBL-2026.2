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


    // Inicio, resp. controlar o andamento do jogo.
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

                hud.HudStatus(
                        estado.confianca, estado.afinidadenpc1,
                        estado.afinidadenpc2, estado.sanidade,
                        estado.lideranca);

                hud.AvisoEnter();


                // Inicia Narrativa

                // CAPÍTULO 1
                Capitulo cena1 = ConstrutorCapitulo.criarCena(
                        "Cena 1 - O DESPERTAR", RepDialogo.cap1cen1);
                cena1.exibirCapitulo();

                Escolha escolha1 = new Escolha("O que Serj deve fazer?")
                        .adicionarOpcao("Examinar os escombros ao redor",
                                estado -> estado.AumentarConfianca(1))
                        .adicionarOpcao("Levantar-se e procurar uma saída",
                                estado -> estado.AumentarLideranca(1));

                Opcao resultado = escolha1.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Examinar os escombros ao redor")) {
                    System.out.println(
                            "\nSerj examina os escombros ao redor e encontra uma pequena abertura entre os destroços."
                    );
                }

                if (resultado.getTexto().equals("Levantar-se e procurar uma saída")) {
                    System.out.println(
                            "\nSerj se levanta e procura uma saída entre os escombros. "
                                    + "Depois de alguns instantes, encontra uma passagem para fora."
                    );
                }


                Capitulo cena2 = ConstrutorCapitulo.criarCena(
                        "Cena 2 - O SILÊNCIO", RepDialogo.cap1cen2);
                cena2.exibirCapitulo();

                Escolha escolha2 = new Escolha("O que Serj deve fazer diante da voz?")
                        .adicionarOpcao("Ignorar a voz",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(5);
                                    estado.AumentarConfianca(2);
                                })
                        .adicionarOpcao("Procurar a origem da voz",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(-1);
                                });

                resultado = escolha2.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Ignorar a voz")) {
                    System.out.println(
                            "\nSerj decide ignorar a voz e permanece ao lado de Ibis. "
                                    + "Os dois continuam pelo corredor."
                    );
                }

                if (resultado.getTexto().equals("Procurar a origem da voz")) {
                    System.out.println(
                            "\nSerj segue a voz por alguns instantes, mas não encontra ninguém. "
                                    + "Percebendo que está se afastando de Ibis, ele decide voltar e continuar com o amigo."
                    );
                }


                Capitulo cena3 = ConstrutorCapitulo.criarCena(
                        "Cena 3 - O PRIMEIRO REGISTRO", RepDialogo.cap1cen3);
                cena3.exibirCapitulo();

                Escolha escolha3 = new Escolha("O que fazer com os registros?")
                        .adicionarOpcao("Levar o mapa e seguir em frente",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(1);
                                })
                        .adicionarOpcao("Vasculhar mais arquivos",
                                estado -> {
                                    estado.AumentarConfianca(2);
                                    estado.AumentarLideranca(1);
                                });

                resultado = escolha3.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Levar o mapa e seguir em frente")) {
                    System.out.println(
                            "\nSerj guarda o mapa e decide que o melhor caminho é seguir em frente."
                    );
                }

                if (resultado.getTexto().equals("Vasculhar mais arquivos")) {
                    System.out.println(
                            "\nSerj continua procurando por mais informações, mas os arquivos restantes "
                                    + "não revelam nada além dos mesmos registros. Sem encontrar algo novo, "
                                    + "ele guarda o que encontrou e segue com Ibis."
                    );
                }


                Capitulo cena4 = ConstrutorCapitulo.criarCena(
                        "Cena 4 - TRÊS CAMINHOS", RepDialogo.cap1cen4);
                cena4.exibirCapitulo();

                Escolha escolha4 = new Escolha("Quem deve decidir o próximo passo?")
                        .adicionarOpcao("Serj assume a liderança",
                                estado -> {
                                    estado.AumentarLideranca(3);
                                    estado.AumentarAfinidadeNPC1(2);
                                })
                        .adicionarOpcao("Deixar Ibis decidir",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(4);
                                    estado.AumentarLideranca(-1);
                                });

                resultado = escolha4.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Serj assume a liderança")) {
                    System.out.println(
                            "\nSerj assume a frente do grupo e decide que os dois seguirão em direção à torre."
                    );
                }

                if (resultado.getTexto().equals("Deixar Ibis decidir")) {
                    System.out.println(
                            "\nIbis observa os símbolos por alguns segundos e escolhe o caminho da torre. "
                                    + "Serj aceita a decisão e os dois continuam juntos."
                    );
                }

                hud.Limparterminal();

                // CAPÍTULO 2
                hud.HudStatus(
                        estado.confianca,
                        estado.afinidadenpc1,
                        estado.afinidadenpc2,
                        estado.sanidade,
                        estado.lideranca);

                Capitulo cena5 = ConstrutorCapitulo.criarCena(
                        "Cena 1 - A CIDADE SEM CÉU", RepDialogo.cap2cen1);
                cena5.exibirCapitulo();

                Escolha escolha5 = new Escolha("O que Serj deve fazer com o jornal?")
                        .adicionarOpcao("Mostrar a Ibis o jornal mais antigo",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(4);
                                })
                        .adicionarOpcao("Esconder o jornal e continuar",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(-1);
                                });

                resultado = escolha5.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Mostrar a Ibis o jornal mais antigo")) {
                    System.out.println(
                            "\nSerj mostra o jornal para Ibis. "
                                    + "Os dois percebem que os desaparecimentos acontecem há décadas."
                    );
                }

                if (resultado.getTexto().equals("Esconder o jornal e continuar")) {
                    System.out.println(
                            "\nSerj guarda o jornal sem mostrar a Ibis. "
                                    + "Os dois continuam pela avenida levando consigo apenas as informações que já possuem."
                    );
                }


                Capitulo cena6 = ConstrutorCapitulo.criarCena(
                        "Cena 2 - O HOMEM DA JANELA", RepDialogo.cap2cen2);
                cena6.exibirCapitulo();

                Escolha escolha6 = new Escolha("Como Serj deve reagir ao aviso?")
                        .adicionarOpcao("Confiar no aviso de Mikhail",
                                estado -> {
                                    estado.AumentarConfianca(3);
                                    estado.AumentarLideranca(1);
                                })
                        .adicionarOpcao("Desconfiar de Mikhail",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(-2);
                                });

                resultado = escolha6.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Confiar no aviso de Mikhail")) {
                    System.out.println(
                            "\nSerj decide levar o aviso de Mikhail a sério e guarda a chave com cuidado."
                    );
                }

                if (resultado.getTexto().equals("Desconfiar de Mikhail")) {
                    System.out.println(
                            "\nSerj não aceita o aviso de imediato. "
                                    + "Mesmo desconfiado, ele decide guardar a chave e continuar com Ibis."
                    );
                }


                Capitulo cena7 = ConstrutorCapitulo.criarCena(
                        "Cena 3 - A REGRA DO ECO", RepDialogo.cap2cen3);
                cena7.exibirCapitulo();

                Escolha escolha7 = new Escolha("O que Serj deve fazer diante da porta?")
                        .adicionarOpcao("Seguir Ibis e abandonar a porta",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(5);
                                })
                        .adicionarOpcao("Tentar abrir a porta mesmo assim",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(1);
                                });

                resultado = escolha7.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Seguir Ibis e abandonar a porta")) {
                    System.out.println(
                            "\nSerj decide confiar no aviso e acompanha Ibis para fora da sala."
                    );
                }

                if (resultado.getTexto().equals("Tentar abrir a porta mesmo assim")) {
                    System.out.println(
                            "\nSerj tenta usar a chave, mas as três batidas ecoam novamente pelo corredor. "
                                    + "Percebendo que não há tempo para descobrir o que existe atrás da porta, "
                                    + "ele recua e segue Ibis."
                    );
                }


                Capitulo cena8 = ConstrutorCapitulo.criarCena(
                        "Cena 4 - O SINAL", RepDialogo.cap2cen4);
                cena8.exibirCapitulo();

                Escolha escolha8 = new Escolha("Como Serj deve reagir à chegada de Deyv?")
                        .adicionarOpcao("Aceitar a ajuda de Deyv",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(5);
                                    estado.AumentarConfianca(2);
                                })
                        .adicionarOpcao("Exigir respostas antes de seguir",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarAfinidadeNPC2(-1);
                                    estado.AumentarConfianca(1);
                                });

                resultado = escolha8.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Aceitar a ajuda de Deyv")) {
                    System.out.println(
                            "\nSerj aceita a ajuda de Deyv. "
                                    + "Os três passam a seguir juntos em direção à estação."
                    );
                }

                if (resultado.getTexto().equals("Exigir respostas antes de seguir")) {
                    System.out.println(
                            "\nSerj exige explicações antes de aceitar Deyv no grupo. "
                                    + "Depois de um breve silêncio, Deyv aponta para a direção da estação. "
                                    + "Sem tempo para discutir, os três seguem juntos."
                    );
                }

                hud.Limparterminal();

                // CAPÍTULO 3
                hud.HudStatus(
                        estado.confianca,
                        estado.afinidadenpc1,
                        estado.afinidadenpc2,
                        estado.sanidade,
                        estado.lideranca);

                Capitulo cena9 = ConstrutorCapitulo.criarCena(
                        "Cena 1 - A ESTAÇÃO", RepDialogo.cap3cen1);
                cena9.exibirCapitulo();

                Escolha escolha9 = new Escolha("Quem deve entrar primeiro no trem?")
                        .adicionarOpcao("Entrar com Ibis primeiro",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(4);
                                    estado.AumentarConfianca(1);
                                })
                        .adicionarOpcao("Mandar Deyv entrar primeiro",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(-2);
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(1);
                                });

                resultado = escolha9.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Entrar com Ibis primeiro")) {
                    System.out.println(
                            "\nSerj entra no trem junto com Ibis e os dois escolhem um dos assentos iluminados."
                    );
                }

                if (resultado.getTexto().equals("Mandar Deyv entrar primeiro")) {
                    System.out.println(
                            "\nDeyv entra no trem primeiro e espera por alguns segundos. "
                                    + "Como nada acontece, ele faz um sinal para Serj e Ibis entrarem também."
                    );
                }


                Capitulo cena10 = ConstrutorCapitulo.criarCena(
                        "Cena 2 - MEMÓRIAS QUE NÃO PERTENCEM", RepDialogo.cap3cen2);
                cena10.exibirCapitulo();

                Escolha escolha10 = new Escolha("Como Serj deve reagir às visões?")
                        .adicionarOpcao("Reforçar Ibis e afastá-lo da janela",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(4);
                                })
                        .adicionarOpcao("Perguntar a Deyv sobre a visão",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(4);
                                    estado.AumentarConfianca(2);
                                });

                resultado = escolha10.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Reforçar Ibis e afastá-lo da janela")) {
                    System.out.println(
                            "\nSerj afasta Ibis da janela e pede para que ele não continue olhando para as visões."
                    );
                }

                if (resultado.getTexto().equals("Perguntar a Deyv sobre a visão")) {
                    System.out.println(
                            "\nSerj pergunta a Deyv sobre aquilo que viu. "
                                    + "Deyv evita responder de imediato, mas a visão desaparece antes que ele consiga explicar."
                    );
                }


                Capitulo cena11 = ConstrutorCapitulo.criarCena(
                        "Cena 3 - O NOME ESCRITO", RepDialogo.cap3cen3);
                cena11.exibirCapitulo();

                Escolha escolha11 = new Escolha("O que Serj deve fazer com a descoberta?")
                        .adicionarOpcao("Contar imediatamente a Ibis",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(5);
                                    estado.AumentarConfianca(1);
                                })
                        .adicionarOpcao("Guardar a informação por enquanto",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(-2);
                                });

                resultado = escolha11.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Contar imediatamente a Ibis")) {
                    System.out.println(
                            "\nSerj conta imediatamente a Ibis sobre o nome de Mikhail. "
                                    + "Os dois ficam em silêncio por alguns segundos."
                    );
                }

                if (resultado.getTexto().equals("Guardar a informação por enquanto")) {
                    System.out.println(
                            "\nSerj decide não contar tudo naquele momento. "
                                    + "Ele guarda a informação para si enquanto os três continuam procurando uma saída."
                    );
                }


                Capitulo cena12 = ConstrutorCapitulo.criarCena(
                        "Cena 4 - A FALSA SAÍDA", RepDialogo.cap3cen4);
                cena12.exibirCapitulo();

                Escolha escolha12 = new Escolha("Em quem Serj deve acreditar?")
                        .adicionarOpcao("Acreditar em Mikhail",
                                estado -> {
                                    estado.AumentarConfianca(3);
                                    estado.AumentarLideranca(1);
                                })
                        .adicionarOpcao("Acreditar na falsa saída",
                                estado -> {
                                    estado.AumentarLideranca(2);
                                    estado.AumentarAfinidadeNPC1(-3);
                                    estado.AumentarAfinidadeNPC2(-3);
                                });

                resultado = escolha12.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Acreditar em Mikhail")) {
                    System.out.println(
                            "\nSerj decide confiar no aviso de Mikhail e permanece diante da passagem."
                    );
                }

                if (resultado.getTexto().equals("Acreditar na falsa saída")) {
                    System.out.println(
                            "\nSerj se aproxima da porta, mas percebe tarde demais que algo está errado. "
                                    + "A passagem desaparece diante deles, obrigando o grupo a continuar."
                    );
                }

                hud.Limparterminal();

                // CAPÍTULO 4
                hud.HudStatus(
                        estado.confianca,
                        estado.afinidadenpc1,
                        estado.afinidadenpc2,
                        estado.sanidade,
                        estado.lideranca);

                Capitulo cena13 = ConstrutorCapitulo.criarCena(
                        "Cena 1 - A CASA DE BAIXO", RepDialogo.cap4cen1);
                cena13.exibirCapitulo();

                Escolha escolha13 = new Escolha("Como Serj deve conduzir o grupo?")
                        .adicionarOpcao("Manter o grupo unido e seguir Elena",
                                estado -> {
                                    estado.AumentarLideranca(3);
                                    estado.AumentarAfinidadeNPC1(2);
                                    estado.AumentarConfianca(1);
                                })
                        .adicionarOpcao("Separar o grupo para investigar",
                                estado -> {
                                    estado.AumentarLideranca(-2);
                                    estado.AumentarConfianca(-2);
                                });

                resultado = escolha13.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Manter o grupo unido e seguir Elena")) {
                    System.out.println(
                            "\nSerj mantém Ibis e Deyv juntos e decide seguir Elena pelos corredores subterrâneos."
                    );
                }

                if (resultado.getTexto().equals("Separar o grupo para investigar")) {
                    System.out.println(
                            "\nO grupo se separa por alguns instantes, mas os corredores parecem mudar de lugar. "
                                    + "Percebendo o risco, Serj chama Ibis e Deyv e os três voltam a seguir juntos."
                    );
                }


                Capitulo cena14 = ConstrutorCapitulo.criarCena(
                        "Cena 2 - O PREÇO", RepDialogo.cap4cen2);
                cena14.exibirCapitulo();

                Escolha escolha14 = new Escolha("Como Serj deve buscar respostas?")
                        .adicionarOpcao("Perguntar a Elena como evitar o sacrifício",
                                estado -> {
                                    estado.AumentarConfianca(3);
                                })
                        .adicionarOpcao("Pressionar Deyv por respostas",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(4);
                                    estado.AumentarConfianca(1);
                                    estado.AumentarAfinidadeNPC1(-2);
                                });

                resultado = escolha14.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Perguntar a Elena como evitar o sacrifício")) {
                    System.out.println(
                            "\nSerj pergunta a Elena como evitar o sacrifício. "
                                    + "Ela explica que a resposta está ligada à própria prisão."
                    );
                }

                if (resultado.getTexto().equals("Pressionar Deyv por respostas")) {
                    System.out.println(
                            "\nSerj pressiona Deyv por respostas. "
                                    + "Depois de alguns segundos de silêncio, Deyv decide revelar apenas o necessário."
                    );
                }


                Capitulo cena15 = ConstrutorCapitulo.criarCena(
                        "Cena 3 - A VERDADE DE DEYV", RepDialogo.cap4cen3);
                cena15.exibirCapitulo();

                Escolha escolha15 = new Escolha("Como Serj deve reagir à confissão?")
                        .adicionarOpcao("Perdoar Deyv e continuar ouvindo",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(6);
                                    estado.AumentarConfianca(3);
                                })
                        .adicionarOpcao("Afastar Deyv do grupo",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(-5);
                                    estado.AumentarLideranca(3);
                                    estado.AumentarAfinidadeNPC1(2);
                                });

                resultado = escolha15.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Perdoar Deyv e continuar ouvindo")) {
                    System.out.println(
                            "\nSerj decide ouvir Deyv até o fim. "
                                    + "A revelação deixa os três ainda mais próximos da verdade sobre a prisão."
                    );
                }

                if (resultado.getTexto().equals("Afastar Deyv do grupo")) {
                    System.out.println(
                            "\nSerj decide manter Deyv afastado por enquanto. "
                                    + "Mesmo assim, Deyv continua seguindo o grupo de longe, pois também conhece o caminho para o centro."
                    );
                }


                Capitulo cena16 = ConstrutorCapitulo.criarCena(
                        "Cena 4 - O RELÓGIO", RepDialogo.cap4cen4);
                cena16.exibirCapitulo();

                Escolha escolha16 = new Escolha("Como Serj deve se preparar para descer?")
                        .adicionarOpcao("Segurar Ibis e Deyv juntos",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(3);
                                    estado.AumentarAfinidadeNPC2(3);
                                })
                        .adicionarOpcao("Descer primeiro e assumir o risco",
                                estado -> {
                                    estado.AumentarLideranca(4);
                                    estado.AumentarConfianca(1);
                                });

                resultado = escolha16.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Segurar Ibis e Deyv juntos")) {
                    System.out.println(
                            "\nSerj mantém Ibis e Deyv próximos e os três se preparam para descer juntos."
                    );
                }

                if (resultado.getTexto().equals("Descer primeiro e assumir o risco")) {
                    System.out.println(
                            "\nSerj desce primeiro pela escada e verifica o caminho. "
                                    + "Depois de perceber que o local está seguro, ele sinaliza para Ibis e Deyv descerem também."
                    );
                }

                hud.Limparterminal();

                // CAPÍTULO 5
                hud.HudStatus(
                        estado.confianca,
                        estado.afinidadenpc1,
                        estado.afinidadenpc2,
                        estado.sanidade,
                        estado.lideranca);

                Capitulo cena17 = ConstrutorCapitulo.criarCena(
                        "Cena 1 - A PRISÃO UNIVERSAL", RepDialogo.cap5cen1);
                cena17.exibirCapitulo();

                Escolha escolha17 = new Escolha("Com quem Serj deve avançar?")
                        .adicionarOpcao("Avançar junto com Ibis",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(4);
                                    estado.AumentarConfianca(1);
                                })
                        .adicionarOpcao("Avançar junto com Deyv",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(4);
                                    estado.AumentarConfianca(2);
                                })
                        .adicionarOpcao("Avançar sozinho",
                                estado -> {
                                    estado.AumentarLideranca(4);
                                });

                resultado = escolha17.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Avançar junto com Ibis")) {
                    System.out.println(
                            "\nSerj escolhe seguir ao lado de Ibis. "
                                    + "Os dois avançam juntos enquanto Deyv permanece próximo."
                    );
                }

                if (resultado.getTexto().equals("Avançar junto com Deyv")) {
                    System.out.println(
                            "\nSerj decide avançar ao lado de Deyv. "
                                    + "Os dois seguem pelo caminho enquanto Ibis os acompanha."
                    );
                }

                if (resultado.getTexto().equals("Avançar sozinho")) {
                    System.out.println(
                            "\nSerj segue sozinho por alguns metros. "
                                    + "O caminho logo se divide novamente, e ele percebe que não consegue avançar sem saber onde Ibis e Deyv estão. "
                                    + "Ele retorna para junto deles."
                    );
                }


                Capitulo cena18 = ConstrutorCapitulo.criarCena(
                        "Cena 2 - O CENTRO", RepDialogo.cap5cen2);
                cena18.exibirCapitulo();

                Escolha escolha18 = new Escolha("O que Serj deve fazer diante da voz?")
                        .adicionarOpcao("Exigir outra solução",
                                estado -> {
                                    estado.AumentarLideranca(3);
                                    estado.AumentarConfianca(2);
                                })
                        .adicionarOpcao("Perguntar o que acontece com quem fica",
                                estado -> {
                                    estado.AumentarConfianca(3);
                                });

                resultado = escolha18.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Exigir outra solução")) {
                    System.out.println(
                            "\nSerj exige que exista outra possibilidade. "
                                    + "A voz permanece em silêncio enquanto os três observam a passagem."
                    );
                }

                if (resultado.getTexto().equals("Perguntar o que acontece com quem fica")) {
                    System.out.println(
                            "\nSerj pergunta o que acontecerá com aquele que permanecer. "
                                    + "A resposta da voz deixa claro que a permanência é algo diferente da morte."
                    );
                }


                Capitulo cena19 = ConstrutorCapitulo.criarCena(
                        "Cena 3 - A ESCOLHA", RepDialogo.cap5cen3);
                cena19.exibirCapitulo();

                Escolha escolha19 = new Escolha("Quem Serj deve escolher para atravessar?")
                        .adicionarOpcao("Escolher Ibis para atravessar",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(5);
                                    estado.AumentarLideranca(2);
                                    estado.AumentarConfianca(-2);
                                })
                        .adicionarOpcao("Escolher Deyv para atravessar",
                                estado -> {
                                    estado.AumentarAfinidadeNPC2(5);
                                    estado.AumentarConfianca(2);
                                    estado.AumentarAfinidadeNPC1(-4);
                                })
                        .adicionarOpcao("Recusar a escolha e procurar outra passagem",
                                estado -> {
                                    estado.AumentarLideranca(4);
                                    estado.AumentarConfianca(1);
                                });

                resultado = escolha19.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Escolher Ibis para atravessar")) {
                    System.out.println(
                            "\nSerj escolhe Ibis para atravessar e os dois se aproximam da passagem. "
                                    + "Porém, a abertura começa a se fechar antes que consigam deixar Deyv para trás."
                    );
                }

                if (resultado.getTexto().equals("Escolher Deyv para atravessar")) {
                    System.out.println(
                            "\nSerj escolhe Deyv e os dois caminham em direção à passagem. "
                                    + "Ibis permanece no salão enquanto o lugar começa a desaparecer ao redor deles."
                    );
                }

                if (resultado.getTexto().equals("Recusar a escolha e procurar outra passagem")) {
                    System.out.println(
                            "\nSerj se recusa a aceitar que alguém precise ficar. "
                                    + "Ele procura outra saída, mas acaba retornando ao mesmo ponto diante da passagem."
                    );
                }


                Capitulo cena20 = ConstrutorCapitulo.criarCena(
                        "Cena 4 - O ÚLTIMO PASSAGEIRO", RepDialogo.cap5cen4);
                cena20.exibirCapitulo();

                Escolha escolha20 = new Escolha("O que Serj deve fazer?")
                        .adicionarOpcao("Confiar nos laços que construiu",
                                estado -> {
                                    estado.AumentarAfinidadeNPC1(2);
                                    estado.AumentarAfinidadeNPC2(2);
                                    estado.AumentarConfianca(2);
                                })
                        .adicionarOpcao("Assumir sozinho a responsabilidade",
                                estado -> {
                                    estado.AumentarLideranca(3);
                                    estado.AumentarConfianca(1);
                                });

                resultado = escolha20.exibirEscolha(scanner, estado);
                System.out.println("\nVocê escolheu: " + resultado.getTexto());

                if (resultado.getTexto().equals("Confiar nos laços que construiu")) {
                    System.out.println(
                            "\nSerj olha para Ibis e Deyv. "
                                    + "Independentemente do que aconteça, decide confiar nos laços que construiu com os dois."
                    );
                }

                if (resultado.getTexto().equals("Assumir sozinho a responsabilidade")) {
                    System.out.println(
                            "\nSerj decide carregar sozinho o peso da decisão. "
                                    + "Mesmo assim, sabe que suas escolhas afetaram os dois que chegaram até ali com ele."
                    );
                }

                hud.Limparterminal();
            }


            // Condições para os finais de jogo.

            if (estado.afinidadenpc1 > estado.afinidadenpc2){
                Capitulo Final = ConstrutorCapitulo.criarCena(
                        "Final", RepDialogo.final1);
                Final.exibirCapitulo();
            }
            else if (estado.afinidadenpc2 > estado.afinidadenpc1) {
                Capitulo Final = ConstrutorCapitulo.criarCena(
                        "Final", RepDialogo.final2);
                Final.exibirCapitulo();
            }
            else if (estado.lideranca == 0
                    && estado.confianca == 0
                    && estado.sanidade == 0) {

                Capitulo Final = ConstrutorCapitulo.criarCena(
                        "Final", RepDialogo.final3);
                Final.exibirCapitulo();
            }

            // não foi implementado o final secreto.

            executando = false;


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
