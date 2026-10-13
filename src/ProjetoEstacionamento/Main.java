package ProjetoEstacionamento;

import java.util.Scanner;

public class Main {


public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ListaEncadeada estacionamento = new ListaEncadeada();

    int opcao;

    do {
        System.out.println("\n================================");
        System.out.println("   SISTEMA DE ESTACIONAMENTO");
        System.out.println("================================");
        System.out.println("1 - Inserir veículo no início");
        System.out.println("2 - Inserir veículo no fim");
        System.out.println("3 - Inserir veículo em uma posição");
        System.out.println("4 - Remover veículo do início");
        System.out.println("5 - Remover veículo do fim");
        System.out.println("6 - Remover veículo de uma posição");
        System.out.println("7 - Verificar posição");
        System.out.println("8 - Listar veículos");
        System.out.println("9 - Pesquisar veículo pela placa");
        System.out.println("10 - Mostrar total de veículos");
        System.out.println("0 - Sair");
        System.out.println("================================");
        System.out.print("Escolha uma opção: ");

        opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {

            case 1:
                estacionamento.inserirInicio(cadastrarVeiculo(entrada));
                break;

            case 2:
                estacionamento.inserirFim(cadastrarVeiculo(entrada));
                break;

            case 3:
                System.out.print("Digite a posição desejada: ");
                int posicaoInserir = entrada.nextInt();
                entrada.nextLine();

                if (posicaoInserir < 0
                        || posicaoInserir > estacionamento.getTamanho()) {
                    System.out.println("Posição inválida!");
                } else {
                    Veiculo veiculo = cadastrarVeiculo(entrada);
                    estacionamento.inserirPosicao(
                            veiculo, posicaoInserir);
                }
                break;

            case 4:
                estacionamento.removerInicio();
                break;

            case 5:
                estacionamento.removerFim();
                break;

            case 6:
                System.out.print("Digite a posição para remover: ");
                int posicaoRemover = entrada.nextInt();
                entrada.nextLine();

                estacionamento.removerPosicao(posicaoRemover);
                break;

            case 7:
                System.out.print("Digite a posição para consultar: ");
                int posicaoConsultar = entrada.nextInt();
                entrada.nextLine();

                estacionamento.verificarPosicao(posicaoConsultar);
                break;

            case 8:
                estacionamento.listar();
                break;

            case 9:
                System.out.print("Digite a placa do veículo: ");
                String placa = entrada.nextLine();

                estacionamento.pesquisar(placa);
                break;

            case 10:
                System.out.println(
                        "Total de veículos estacionados: "
                        + estacionamento.getTamanho());
                break;

            case 0:
                System.out.println("Sistema encerrado!");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }

    } while (opcao != 0);

    entrada.close();
}


public static Veiculo cadastrarVeiculo(Scanner entrada) {
    System.out.println("\n===== CADASTRO DE VEÍCULO =====");

    System.out.print("Placa: ");
    String placa = entrada.nextLine();

    System.out.print("Modelo do veículo: ");
    String modelo = entrada.nextLine();

    System.out.print("Cor: ");
    String cor = entrada.nextLine();

    System.out.print("Nome do proprietário: ");
    String proprietario = entrada.nextLine();

    return new Veiculo(placa, modelo, cor, proprietario);
}

}
