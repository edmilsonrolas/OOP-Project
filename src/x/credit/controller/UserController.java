/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package x.credit.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import x.credit.model.User;

/**
 *
 * @author rolas
 */
public class UserController {
    public static void registar(User u) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("user.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(u);
            
            fileOutputStream.flush();
            fileOutputStream.close();
            
            objectOutputStream.flush();
            objectOutputStream.close();
            
            JOptionPane.showMessageDialog(null, "registado com sucesso!");
            
        }catch(Exception e) {
            e.printStackTrace( );
        }
    }
    
    public static User returnUser() {
        User u = new User();
        try{
            FileInputStream fileInputStream = new FileInputStream("user.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            u = (User) objectInputStream.readObject();
                
            fileInputStream.close();
            objectInputStream.close();
//        }catch(EOFException e){
//            return LISTA_USUARIOS;
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return u;
    }
    
    public static void persistir(List<User> users){
        
    }
    
    public static void remover(String username) {
       
    }
    
    public static void updateUser(User user) {
//        User u = returnUser();
//                u.setNome(user.getNome());
//                u.setApelido(user.getApelido());
//                u.setNomeUsuaro(user.getNomeUsuaro());
//                u.setEmail(user.getEmail());
//                u.setTelefone(user.getTelefone());
//                u.setBiografia(user.getBiografia());
//                u.setSenha(user.getSenha());
    }
    
    public static boolean autentica(User u) {
        if (u.getUserName().equals(returnUser().getUserName()) && u.getSenha().equals(returnUser().getSenha())) {
            return true;
        }

        return false;
    }
    
//    public static boolean userNameExiste(String s) {
//        List<User> users = listar();
//        boolean existe = users.stream().anyMatch(p -> (p.getNomeUsuaro().equals(s)));
//        return existe;
//    }
    
//    public static User pesquisa(String userName){
//        List<User> users = listar();
//        for (User user : users) {
//            if (user.getNomeUsuaro().equals(userName)) {
//                
//                return user;
//            }
//                break;
//        }
//        return null;
//    }
    
    public static String retornarBio() {
        return returnUser().getBiografia();
    }
    
//    public static void pesquisar(String text) {
//        for (User user : listar()) {
//            if (user.getNomeUsuaro().equals(text)) {
//                System.out.println(user);
//            }
//        }
//    }
    
    public static void main(String[] args) {
        System.out.println(returnUser());
//        registar(new User("Josefa","Mario","ja@mail","8999","josima","bbbb","senha", new BigDecimal(BigInteger.ZERO)));
//        remover("andressa");
//        alterar("5580eec0-fa3c-4466-88bf-24a5fcb691c1", new User("anita", "paulitaa", "ap@mail", "8998", "anapaula", "bbbb", "senha"));
//        System.out.println(autentica(new User("josimak", "senha")));
//        System.out.println(retornarBio());
//        JOptionPane.showMessageDialog(null, "ola", "boas vindas", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "ola", "boas vindas", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "ola", "boas vindas", JOptionPane.INFORMATION_MESSAGE);
    }

}