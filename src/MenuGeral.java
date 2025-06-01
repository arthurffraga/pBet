import java.util.Scanner;
import java.util.ArrayList;
public class MenuGeral {
    public static void menuPrincipal() {
        Scanner input = new Scanner(System.in);
        String opcao = "";
        while(!opcao.equals("5")) {
            System.out.println("Menu principal");
            System.out.println("Digite uma das opções abaixo:");
            System.out.println("1- Cadastrar");
            System.out.println("2- Listar");
            System.out.println("3- Atualizar");
            System.out.println("4- Excluir");
            System.out.println("5- Sair");
            opcao = input.next();
            if(opcao.equals("1")) {
                Usuario novoUsuario = Usuario.cadastrar();
                ArrayList<Usuario> lista = Arquivos.ler();
                lista.add(novoUsuario);
                Arquivos.salvarTodos(lista);
                
            }
            else if(opcao.equals("2")) {
            	Usuario.listarUsuarios();
                
            }
            else if(opcao.equals("3")) {
            	Usuario.atualizarUsuario();
                
            }
            else if(opcao.equals("4")) {
            	Usuario.excluirUsuario();
                
            }
            else if(opcao.equals("5")) {
                break;
            }
            else {
                System.out.println("Digite uma das opções \n");
            }
        }

    }
}
