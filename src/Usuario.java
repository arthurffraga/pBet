import java.io.Serializable;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class Usuario extends Pessoa{
    public Usuario(String nome, int idade, String cpf, String numero) {
        super(nome, idade, cpf, numero);
    }
    @Override
    public String toString() {
        return String.format("Nome: %s || Idade: %d || CPF: %s || Número: %s", getNome(), getIdade(), getCpf(), getNumero());
    }

    public static Usuario cadastrar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome:");
        String nome = "";
        boolean nome2 = false;
        while (!nome2){
            nome = input.next();
            if (nome.matches("[a-zA-Z]+")){
                nome2 = true;
                break;
            }
            else{
                System.out.println("Digite um nome com apenas letras");
            }
        }
        System.out.println("Digite a idade (Tem que ser maior de idade):");
        int idade = 0;
        boolean idade2 = false;
        while (!idade2 ) {
            try {
                idade = input.nextInt();
                if (idade >= 18) {
                	idade2 = true;
                }
                else {
                	System.out.println("A idade tem que ser maior que 18");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro:");
                input.nextLine();
            }
        }
        System.out.println("Digite o cpf:");
        String cpf = "";
        boolean cpf2 = false;
        while (!cpf2) {
            cpf = input.next();
            if(cpf.matches("\\d{11}")){
                cpf2 = true;
            }
            else {
                System.out.println("Digite um cpf valido");
            }
        }
        System.out.println("Digite o número para contato:");
        String numero = "";
        boolean num2 = false;
        while (!num2) {
            numero = input.next();
            if(numero.matches("\\d{11}")){
                num2 = true;
            }
            else {
                System.out.println("Digite um número valido");
            }
        }
        System.out.println("Deseja cadastrar esse usuário?");
        System.out.printf("Nome: %s || Idade: %d || CPF: %s || Número: %s %n", nome,idade,cpf,numero);
        System.out.println("\n1- Sim\n2- Não");
        String resposta = "";
        boolean resposta2 = false;
        while (!resposta2) {
            resposta = input.next();
            if (resposta.equals("1")) {
                System.out.println("usuário cadastrado");
                resposta2 = true;
            } else if (resposta.equals("2")) {
                MenuGeral.menuPrincipal();
            }
            else {
                System.out.println("digite uma das opções");
            }
        }
        Usuario uso = new Usuario (nome, idade, cpf, numero);
        return uso;
    }

    public static void listarUsuarios() {
        ArrayList<Usuario> lista = Arquivos.ler();
        int i = 0;
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        }
        else {
            for (Usuario u : lista) {
                System.out.printf("ID: %d || %s %n", i += 1,u);
                }
            }
        }
    public static void atualizarUsuario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual c vai ser atualizado? Digite pelo id");
        ArrayList<Usuario> listaU = Arquivos.ler();
        int i = 0;
        if (listaU.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada");
        }
        else {
            for (Usuario p : listaU) {
                System.out.printf("ID: %d || %s %n", i+=1 , p);
            }
        }
        int id = input.nextInt();
        Usuario usuario = listaU.get(id - 1);
        System.out.println("O que vc deseja alterar?");
        System.out.println("1- Nome\n2- Idade\n3- CPF\n4- Número\n");
        String opcao = "";
        while (true) {
            opcao = input.next();
            if (opcao.equals("1")) {
                System.out.println("Digite o novo nome:");
                String nome = "";
                boolean nome2 = false;
                while (!nome2){
                    nome = input.next();
                    if (nome.matches("[a-zA-Z]+")){
                        nome2 = true;
                    }
                    else{
                        System.out.println("Digite um nome com apenas letras");
                    }
                }
                usuario.setNome(nome);
                Arquivos.salvarTodos(listaU);
                System.out.println("Nome atualizado!");
                break;
            }
            else if (opcao.equals("2")){
                System.out.println("Digite a nova idade:");
                int idade = 0;
                boolean idadeV = false;
                while (!idadeV) {
                    try {
                        idade = input.nextInt();
                        idadeV = true;

                    } catch (InputMismatchException e) {
                        System.out.println("Digite um número inteiro:");
                        input.nextLine();
                    }
                }
                usuario.setIdade(idade);
                Arquivos.salvarTodos(listaU);
                System.out.println("Idade atualizada!");
                break;
            }
            else if (opcao.equals("3")) {
                System.out.println("Digite o novo CPF:");
                String cpf = "";
                boolean cpfV = false;
                while (!cpfV) {
                    cpf = input.next();
                    if(cpf.matches("\\d{11}")){
                        cpfV = true;
                    }
                    else{
                        System.out.println("Digite um cpf valido");
                    }
                }
                usuario.setCpf(cpf);
                Arquivos.salvarTodos(listaU);
                System.out.println("CPF atualizado!");
                break;
            }
            else if (opcao.equals("4")) {
                System.out.println("Digite o novo número:");
                String numero = "";
                boolean numV = false;
                while (!numV) {
                    numero = input.next();
                    if(numero.matches("\\d{11}")){
                        numV = true;
                    }
                    else{
                        System.out.println("Digite um número valido");
                    }
                }
                usuario.setNumero(numero);
                Arquivos.salvarTodos(listaU);
                System.out.println("Número atualizado!");
                break;
            }
            else {
                System.out.println("Digite uma das opções");
                System.out.println("1- Nome\n2- Idade\n3- CPF\n4- Número\n");
            }
        }
    }
    public static void excluirUsuario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual usuário vai ser excluido? Digite pelo id");
        ArrayList<Usuario> listaU2 = Arquivos.ler();
        int i = 0;
        if (listaU2.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado");
            return;
        }
        else {
            for (Usuario a : listaU2) {
                System.out.printf("ID: %d || %s %n", i+=1 , a);
            }
        }
        int id3 = input.nextInt();
        listaU2.remove(id3 - 1);
        System.out.println("usuário excluído!");
        Arquivos.salvarTodos(listaU2);
    }
}
