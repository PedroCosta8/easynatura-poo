package easyNatura.model.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import easyNatura.model.Cliente;
import easyNatura.model.Produto;
import easyNatura.model.Usuario;
import easyNatura.model.Venda;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Banco {
    
    public static ArrayList<Produto> produtos;
    public static java.lang.reflect.Type typeProduto = new TypeToken<List<Produto>>(){}.getType();
    public static ArrayList<Cliente> clientes;
    public static java.lang.reflect.Type typeCliente = new TypeToken<List<Cliente>>(){}.getType();
    public static ArrayList<Usuario> usuarios;
    public static java.lang.reflect.Type typeUsuario = new TypeToken<List<Usuario>>(){}.getType();
    public static ArrayList<Venda> vendas;
    public static java.lang.reflect.Type typeVenda = new TypeToken<List<Venda>>(){}.getType();
    
    public static void inicia(){
        Banco.produtos = new ArrayList<>();
        try {
            
            File filePath = new File("produtos.json");
            Reader reader = new FileReader(filePath);
            Gson gson = new Gson();
            Banco.produtos = gson.fromJson(reader, Banco.typeProduto);
           
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo com os produtos não foi carregado com sucesso");
        }
        
        Banco.clientes = new ArrayList<>();
        try {
            
            File filePath = new File("clientes.json");
            Reader reader = new FileReader(filePath);
            Gson gson = new Gson();
            Banco.clientes = gson.fromJson(reader, Banco.typeCliente);
           
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo com os clientes não foi carregado com sucesso");
        }
        
        Banco.usuarios = new ArrayList<>();
        try {
            
            File filePath = new File("usuarios.json");
            Reader reader = new FileReader(filePath);
            Gson gson = new Gson();
            Banco.usuarios = gson.fromJson(reader, Banco.typeUsuario);
           
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo com os usuários não foi carregado com sucesso");
        }
        
        Banco.vendas = new ArrayList<>();
        try {
            
            File filePath = new File("vendas.json");
            Reader reader = new FileReader(filePath);
            Gson gson = new Gson();
            Banco.vendas = gson.fromJson(reader, Banco.typeVenda);
           
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo com as vendas não foi carregado com sucesso");
        }
    }
}