import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();


        PessoaFisica metodosPf = new PessoaFisica();
        PessoaJuridica metodosPj = new PessoaJuridica();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoa Física e Pessoa Jurídica");

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {

            System.out.println("\nEscolha uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            System.out.print("> ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoPf;
                    do {

                        System.out.println("\nEscolha uma opção: 1 - Cadastrar Pessoa Física / 2 - Listar Pessoa Física / 0 - Voltar ao menu anterior ");
                        System.out.print("> ");
                        opcaoPf = scanner.nextInt();

                        switch (opcaoPf){
                            case 1:
                                PessoaFisica novapf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.print("\nDigite o nome da pessoa física: ");
                                novapf.nome = scanner.next();

                                System.out.print("Digite o CPF: ");
                                novapf.cpf = scanner.next();

                                System.out.print("Digite o rendimento mensal (Digite somente numero): ");
                                novapf.rendimento = scanner.nextInt();

                                System.out.print("Digite a data de Nascimento (dd/MM/aaaa): ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo = Period.between(date, LocalDate.now());

                                novapf.dataNascimento = date;

                                if (periodo.getYears() >= 18){
                                    System.out.print("A pessoa tem mais de 18 anos");
                                }else {
                                    System.out.print("A pessoa tem menos de 18 anos. Retornando menu...");
                                    break;
                                }

                                System.out.println("\nDigite o logradouro: ");
                                novoEndPf.logradouro = scanner.next();

                                System.out.print("Digite o número: ");
                                novoEndPf.numero = scanner.next();

                                System.out.print("Este endereço é comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")){
                                    novoEndPf.enderecoComercial = true;
                                }else {
                                    novoEndPf.enderecoComercial = false;
                                }

                                novapf.endereco = novoEndPf;

                                listaPf.add(novapf);

                                System.out.println("\nCadastro realizado com sucesso!");

                                break;
                            case 2:
                                if(listaPf.size() > 0){
                                    for (PessoaFisica cadaPf : listaPf){
                                        System.out.println("\nNome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("\nDigite 0 para continuar");
                                        scanner.nextLine();
                                    }

                                    opcaoPf = scanner.nextInt();

                                } else {
                                    System.out.println("\nLista vazia");
                                }

                                break;
                            case 0:
                                System.out.println("\nVoltando ao menu anterior");
                                break;
                            default:
                                System.out.println("\nOpção inválida, por favor digite uma opção válida!");
                                break;
                        }

                    } while (opcaoPf != 0);

                    break;
                case 2:
                    int opcaoPj;
                    do {

                        System.out.println("\nEscolha uma opção: 1 - Cadastrar Pessoa Juridica / 2 - Listar Pessoa Juridica / 0 - Voltar ao menu anterior ");
                        System.out.print("> ");
                        opcaoPj = scanner.nextInt();

                        switch (opcaoPj) {
                            case 1:
                                PessoaJuridica novapj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.print("\nDigite o nome da pessoa juridica: ");
                                novapj.nome = scanner.next();

                                System.out.print("Digite o CNPJ: ");
                                novapj.cnpj = scanner.next();

                                System.out.print("Digite o rendimento mensal (Digite somente numero): ");
                                novapj.rendimento = scanner.nextInt();

                                System.out.print("Digite a razao social: ");
                                novapj.razaoSocial = scanner.next();

                                System.out.print("Digite o logradouro: ");
                                novoEndPj.logradouro = scanner.next();

                                System.out.print("Digite o número: ");
                                novoEndPj.numero = scanner.next();

                                System.out.print("Este endereço é comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")){
                                    novoEndPj.enderecoComercial = true;
                                }else {
                                    novoEndPj.enderecoComercial = false;
                                }

                                novapj.endereco = novoEndPj;

                                listaPj.add(novapj);

                                System.out.println("\nCadastro realizado com sucesso!");

                                break;

                            case 2:
                                if (listaPj.size() > 0){
                                    for(PessoaJuridica cadaPj : listaPj){
                                        System.out.println("\nNome: " + cadaPj.nome);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Logradouro: " + cadaPj.endereco.logradouro + " " + cadaPj.endereco.numero);
                                        System.out.println("Razao Social: " + cadaPj.razaoSocial);
                                        System.out.println("Imposto a ser pago: " + metodosPj.CalcularImposto(cadaPj.rendimento));
                                        System.out.println("\nDigite 0 para continuar");
                                        scanner.nextLine();
                                    }

                                    opcaoPj = scanner.nextInt();
                                } else {
                                    System.out.println("\nLista vazia");
                                }

                                break;

                            case 0:
                                System.out.println("\nVoltando ao menu anterior");
                                break;
                            default:
                                System.out.println("\nOpção inválida, por favor digite uma opção válida!");
                                break;
                        }
                    } while (opcaoPj != 0);
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar o nosso sistema! Forte abraço! ");
                    break;
                default:
                    System.out.println("\nOpção inválida, por favor digite uma opção válida!");
                    break;
            }

        } while (opcao != 0);
    }
}





