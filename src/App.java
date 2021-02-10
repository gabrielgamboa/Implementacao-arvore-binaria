//HT3001385
//GABRIEL DE BARROS GAMBÔA

import java.util.Scanner;

import Arvore.ABBNome;
import Arvore.ABBProntuario;
import Models.Aluno;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao = 0;

        ABBNome arvoreNome = new ABBNome();
        ABBProntuario arvoreProntuario = new ABBProntuario();

        Scanner s = new Scanner(System.in);

        System.out.println("Seja bem vindo!\n");

        while (opcao != 5) {

            System.out.println("\n\n1. Cadastrar um aluno\n" + "2. Buscar um aluno\n" + "3. Listar os alunos\n" + "4. Remover um aluno\n" + "5. Sair do programa\n");
            System.out.println("\nDigite a opção desejada: ");
            opcao = s.nextInt();

            if (opcao == 1) {
                System.out.println("Digite o nome do aluno:");
                String nome = s.next();

                System.out.println("\nDigite o prontuário: ");
                int prontuario = s.nextInt();

                System.out.println("\nDigite o curso do aluno: ");
                String curso = s.next();

                Aluno aluno = new Aluno(nome, prontuario, curso);
                arvoreNome.inserir(aluno);
                arvoreProntuario.inserir(aluno);

                System.out.println("\nAluno cadastrado com sucesso no sistema!");
                

            }

            if (opcao == 2) {
                System.out.println("\n1. Buscar pelo Prontuário");
                System.out.println("2. Buscar pelo Nome");

                int opcaoBusca = s.nextInt();

                if (opcaoBusca == 1) {
                    System.out.println("\nDigite o prontuário que deseja buscar:");
                    int prontuario = s.nextInt();

                    Aluno aluno = arvoreProntuario.buscar(prontuario);

                    System.out.println("\n\nAluno encontrado! \n\nNome: " + aluno.getNome() + "\nProntuário: " + aluno.getProntuario() + "\nCurso: " + aluno.getCurso());
                } else {

                    System.out.println("\nDigite o nome do aluno que você deseja buscar:");
                    String nome = s.next();

                    Aluno aluno = arvoreNome.buscar(nome);

                    if (aluno == null) {
                        System.out.println("\nNão encontramos este aluno dentro do nosso sistema.");
                    } else {
                        System.out.println("\n\nAluno encontrado! \n\nNome: " + aluno.getNome() + "\nProntuário: " + aluno.getProntuario() + "\nCurso: " + aluno.getCurso());
                    }
                }
            }

            if (opcao == 3) {
                System.out.println("\n1. Listar em pré-ordem");
                System.out.println("2. Listar em ordem");
                System.out.println("2. Listar em pós-ordem");

                int opcaoListagem = s.nextInt();

                if (opcaoListagem == 1) {
                    System.out.println("\nListando pelo nome...\n");
                    arvoreNome.imprimirPreOrdem();

                    System.out.println("\nListando pelo prontuário...\n");
                    arvoreProntuario.imprimirPreOrdem();

                } else if (opcaoListagem == 2) {
                    System.out.println("\nListando pelo nome...\n");
                    arvoreNome.imprimirEmOrdem();

                    System.out.println("\nListando pelo prontuário...\n");
                    arvoreProntuario.imprimirEmOrdem();

                } else {
                    System.out.println("\nListando pelo nome...\n");
                    arvoreNome.imprimirPosOrdem();

                    System.out.println("\nListando pelo prontuário...\n");
                    arvoreProntuario.imprimirPosOrdem();
                }
            }

            if (opcao == 4) {
                System.out.println("\nDigite o prontuário do aluno que você deseja remover do sistema: ");
                int prontuarioRemover = s.nextInt();
                
                Aluno aluno = arvoreProntuario.remover(prontuarioRemover);
                arvoreNome.remover(aluno.getNome());

                System.out.println("\nElemento removido da árvore com sucesso!");
                
            }


            if (opcao == 5) {
                System.out.println("Saindo do programa...");
            }
        }

        s.close();
    }
}
