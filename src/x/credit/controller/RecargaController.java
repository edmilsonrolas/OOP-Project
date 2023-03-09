/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package x.credit.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import x.credit.model.Recarga;

/**
 *
 * @author rolas
 */
public class RecargaController {
    public static Boolean registar(Recarga r) {
        if (recargaExiste(r.getOperadora(), r.getValor())) {
            JOptionPane.showMessageDialog(null, "Ja existe uma recarga de "+r.getValor()+" "+r.getOperadora()+" registada.", "Registo invalido!:", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            List<Recarga> recargas = listar();
            recargas.add(r);
            persistir(recargas);
            JOptionPane.showMessageDialog(null, "Registado com sucesso!");
            return true;
        }
    }
    
    public static List<Recarga> listar() {
        List<Recarga> recargas = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("recargas.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            recargas = (List<Recarga>) objectInputStream.readObject();
                
            fileInputStream.close();
            objectInputStream.close();
//        }catch(EOFException e){
//            return LISTA_USUARIOS;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return recargas;
    }
    
    public static void persistir(List<Recarga> recargas){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("recargas.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(recargas);
            
            fileOutputStream.flush();
            fileOutputStream.close();
            
            objectOutputStream.flush();
            objectOutputStream.close();
            
        }catch(Exception e) {
            e.printStackTrace( );
        }
    }
    
    public static void removerRecarga(String id) {
        List<Recarga> recargas = listar();
        for (Recarga r : recargas) {
            if (r.getId().equals(id)) {
                recargas.remove(r);
                persistir(recargas);
                break;
            }
        }
    }
    
    public static void acrescentarQuantidadeRecargas(String id, int quantty) {
        List<Recarga> recargas = listar();
        for (Recarga r : recargas) {
            if (r.getId().equals(id)) {
                r.setQuantidadeStock(r.getQuantidadeStock()+quantty);
                persistir(recargas);
                break;
            }
        }
    }
    
    public static void reduzirQuantidadeRecargas(String id, int quantty) {
        List<Recarga> recargas = listar();
        for (Recarga r : recargas) {
            if (r.getId().equals(id)) {
                r.setQuantidadeStock(r.getQuantidadeStock()-quantty);
                persistir(recargas);
                break;
            }
        }
    }
    
    public static boolean recargaExiste(String op, Integer val) {
        List<Recarga> recargas = listar();
        boolean existe = recargas.stream().anyMatch(p -> (p.getOperadora().equalsIgnoreCase(op) && p.getValor().equals(val)));
        return existe;
    }
    
    public static void main(String[] args) {
        System.out.println(listar());
//        registar(new Recarga("mv50",50,"movitel",8999));
//        removerRecarga("mv50");
//        alterar("5580eec0-fa3c-4466-88bf-24a5fcb691c1", new User("anita", "paulitaa", "ap@mail", "8998", "anapaula", "bbbb", "senha"));
//        System.out.println(listar());
    }
}