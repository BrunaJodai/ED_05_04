package ArvoreBuscaBinaria;

import java.util.Scanner;

/**
 *
 * @author Bruna Jodai
 */
public class Principal {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ABB arv = new ABB();
        int opcao = 0;

        do {
            System.out.println("-- ÁRVORE DE BUSCA BINÁRIA --");
            System.out.println("1 - Inserção;");
            System.out.println("2 - Busca;");
            System.out.println("3 - Remoção;");
            System.out.println("0 - Sair.");
            System.out.print("~ Insira a opção: ");
            opcao = Integer.parseInt(console.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Dado: ");
                    int d = Integer.parseInt(console.nextLine());
                    System.out.print("nome: ");
                    String nom = console.nextLine();

                    arv.inserirNo(d, nom);
                    break;

                case 2:
                    System.out.print("Buscar dado: ");
                    int busca = Integer.parseInt(console.nextLine());

                    System.out.println("Resultado: " +arv.buscarNo(busca));
                    break;

                case 3:
                    System.out.print("Remover dado: ");
                    int remove = Integer.parseInt(console.nextLine());
                    
                    System.out.println("Resutado: " +arv.remover(remove));
                    break;
            }
            System.out.println("");
        } while (opcao != 0);
    }
}
