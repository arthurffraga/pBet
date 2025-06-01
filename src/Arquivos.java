import java.io.*;
import java.util.ArrayList;
public class Arquivos {
    public static void salvarTodos(ArrayList<Usuario> lista) {
        try {
            FileOutputStream arquivo = new FileOutputStream("usuarios.ser");
            ObjectOutputStream escrever = new ObjectOutputStream(arquivo);
            for (Usuario u: lista) {
             escrever.writeObject(u);
            }
            escrever.close();
        } 
        catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os usuarios.");
        }
    }

    public static ArrayList<Usuario> ler(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            FileInputStream arquivo = new FileInputStream("usuarios.ser");
            ObjectInputStream escrever = new ObjectInputStream(arquivo);
            while (true) {
                try {
                    Usuario usuario = (Usuario) escrever.readObject();
                    lista.add(usuario);
                } catch (EOFException e) {
                    break;
                }
            }
            escrever.close();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("");
        }
        return lista;
    }
}
