import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner responsável pela entrada de dados do menu
        Scanner ler = new Scanner(System.in);

        // Instância única da conta bancária
        ContaDoBanco c1 = new ContaDoBanco();

        // Armazena a opção selecionada no menu
        int opcao = 0;

        // Loop principal da aplicação
        do {
            System.out.println("Olá! Sou o assistente virtual do Banco!");
            System.out.println("Qual das opções você deseja usar?");
            System.out.println("1 - Abrir Conta");
            System.out.println("2 - Fechar Conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Pagar Mensalidade");
            System.out.println("6 - Ver Saldo");
            System.out.println("7 - Fechar o App");

            // Leitura da opção do usuário
            opcao = ler.nextInt();

            // Direciona a execução conforme a opção escolhida
            switch (opcao) {
                case 1:
                    c1.abrirConta();
                    break;
                case 2:
                    c1.fecharConta();
                    break;
                case 3:
                    c1.depositar();
                    break;
                case 4:
                    c1.sacar();
                    break;
                case 5:
                    c1.pagarMensalidade();
                    break;
                case 6:
                    c1.status();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }

        } while (opcao != 7); // Encerra o sistema quando o usuário escolhe sair
    }
}
