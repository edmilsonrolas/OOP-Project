/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.credit.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static x.credit.controller.RecargaController.listar;
import static x.credit.controller.RecargaController.persistir;
import static x.credit.controller.RecargaController.recargaExiste;
import x.credit.model.Recarga;
import x.credit.model.Transacao;

/**
 *
 * @author Edmilson Rolas
 */
public class TransacaoController {
    
    public static int contarTs(){
        return listar().size();
    }
    
    public static boolean idExiste(Integer i) {
        List<Transacao> ts = listar();
        boolean existe = ts.stream().anyMatch(p -> (p.getId().equals(i)));
        return existe;
    }
    
    public static void registar(Transacao t) {
        int i = 0;
        while (idExiste(i)) {
            i++;
        }        
        List<Transacao> ts = listar();
        t.setId(i);
        ts.add(t);
        persistir(ts);
    }
    
    public static List<Transacao> listar() {
        List<Transacao> ts = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("transacoes.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ts = (List<Transacao>) objectInputStream.readObject();
                
            fileInputStream.close();
            objectInputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ts;
    }
    
    public static void persistir(List<Transacao> ts){
        try{
            FileOutputStream fileOutputStream = 
                    new FileOutputStream("transacoes.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(ts);
            
            fileOutputStream.flush();
            fileOutputStream.close();
            
            objectOutputStream.flush();
            objectOutputStream.close();
            
        }catch(Exception e) {
            e.printStackTrace( );
        }
    }
    
    public static void pesquisar(int i) {
        for (Transacao t : listar()) {
            if (t.getId().equals(i)) {
                System.out.println(t);
            }
        }
    }
    
//    public void maisSaldo(BigDecimal valor) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//		
////		String linhas[] = new String[3];	//precisa q 0 nr de posicoes seja especificado
//		ArrayList<String> linhas = new ArrayList<String>();	//nao precisa q 0 nr de posicoes seja especificado
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.print("Jogador "+i+": ");
//			String nome = scanner.nextLine();
//			
//			linhas.add(nome);
//		}
//		
//		Path arquivo = Paths.get("D:/joo/ficheiros/arquivo.txt"); 
//		Files.write(arquivo, linhas);	//lines - array de strigs, onde cada posicao refere a uma linha do arquivo
//		
//		scanner.close();
//		System.out.println("Fim...");
//    }
    
    public static void main(String[] args) {
//           System.out.println(listar());
//           registar(new Transacao("ev", Date.from(Instant.now()).toString(), "descricao"));
           System.out.println(listar());
//           pesquisar(1);//           pesquisar(1);
//           pesquisar(1);

           
           
//           Date.from(Instant.now()).toString()
//        System.out.println(contarUsuarios());
//        List<String> l = new ArrayList<>();
//        l.add("String 1");
//        l.add("String 2");
//        l.add("String 3");
//        l.add("String 4");
//        l.add("String 5");
//        System.out.println(l.get(l.size()-1));
    }



}
