import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contCadastro = 0;
        String[] nomeLivro = new String[50];
        String[] autorLivro = new String[50];
        boolean[] emprestado = new boolean[50];
        boolean parar = true;

        while (parar) {
            System.out.println("==============================");
            System.out.println("          BIBLIOTECA          ");
            System.out.println("==============================");

            System.out.println("  [1] - Cadastrar Livros");
            System.out.println("  [2] - Listar Livros");
            System.out.println("  [3] - Buscar Livros");
            System.out.println("  [4] - Alugar Livros");
            System.out.println("  [5] - Devolver Livros");
            System.out.println("  [0] - Sair");

            int opcao;
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Digite apenas números!");
                sc.nextLine();
                System.out.println();
                continue;
            }

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando programa...");
                    parar = false;
                    break;
                case 1:
                    for (; contCadastro < nomeLivro.length; ) {
                        System.out.print("Insira o titulo do livro: ");
                        nomeLivro[contCadastro] = sc.nextLine();
                        System.out.print("Insira o nome do autor do livro: ");
                        autorLivro[contCadastro] = sc.nextLine();
                        emprestado[contCadastro] = false;
                        contCadastro++;

                        char opcao1;
                        while (true) {
                            System.out.print("Deseja continuar inserindo livro? [S/N]: ");
                            opcao1 = sc.next().charAt(0);
                            sc.nextLine();
                            System.out.println();
                            if (opcao1 == 'S' || opcao1 == 's') {
                                break;
                            } else if (opcao1 == 'N' || opcao1 == 'n') {
                                break;
                            } else {
                                System.out.println("Opção inválida! Digite apenas S ou N.");
                            }
                        }
                        if (opcao1 == 'S' || opcao1 == 's') {
                            continue;
                        } else if (opcao1 == 'N' || opcao1 == 'n') {
                            break;
                        }
                    }
                    break;

                case 2:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para listar!");
                        System.out.println();
                        break;
                    } else {
                        for (int i = 0; i < contCadastro; i++) {
                            if (nomeLivro[i] == null) {
                            } else {
                                System.out.println();
                                System.out.println("Livro: " + nomeLivro[i]);
                                System.out.println("Autor: " + autorLivro[i]);
                                if (emprestado[i]) {
                                    System.out.println("Status: Alugado");
                                    System.out.println();
                                } else {
                                    System.out.println("Status: Não alugado");
                                    System.out.println();

                                }
                            }
                        }
                    }
                    break;
                case 3:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para fazer a busca!");
                        System.out.println();
                        break;
                    } else {
                        System.out.println();
                        System.out.print("Qual livro desejar procurar: ");
                        String buscar = sc.nextLine();
                        System.out.println();
                        boolean encontrado = false;

                        for (int i = 0; i < contCadastro; i++) {
                            if (nomeLivro[i].equalsIgnoreCase(buscar)) {
                                encontrado = true;
                                System.out.println("Livro: " + nomeLivro[i]);
                                System.out.println("Autor: " + autorLivro[i]);
                                if (emprestado[i]) {
                                    System.out.println("Status: Alugado");
                                    System.out.println();
                                } else {
                                    System.out.println("Status: Não alugado");
                                    System.out.println();
                                }
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Livro não existe no sistema!");
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para alugar!");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.print("Qual nome do livro que deseja alugar: ");
                        String alugar = sc.nextLine();
                        System.out.println();
                        boolean encontrado = false;

                        for (int i = 0; i < contCadastro; i++) {
                            if (nomeLivro[i].equalsIgnoreCase(alugar)) {
                                encontrado = true;
                                if (emprestado[i]) {
                                    System.out.println("Este livro já está alugado!");
                                    System.out.println();
                                } else {
                                    emprestado[i] = true;
                                    System.out.println("Este livro foi alugado com sucesso!");
                                    System.out.println();
                                }
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Livro não encontrado no sistema para alugar!");
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para ser devolvido!");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.print("Qual o livro que irá ser devolvido: ");
                        String devolucao = sc.nextLine();
                        System.out.println();
                        boolean encontrado = false;

                        for (int i = 0; i < contCadastro; i++) {
                            if (nomeLivro[i].equalsIgnoreCase(devolucao)) {
                                encontrado = true;
                                if (emprestado[i]) {
                                    emprestado[i] = false;
                                    System.out.println("Livro devolvido com sucesso!");
                                    System.out.println();
                                }else{
                                    System.out.println("Este livro não foi alugado, então não pode ser devolvido!");
                                    System.out.println();
                                }

                            }
                        }
                        if (!encontrado){
                            System.out.println("Livro não encontrado no sistema para ser devolvido!");
                            System.out.println();
                        }
                    }
            }
        }
    }
}

