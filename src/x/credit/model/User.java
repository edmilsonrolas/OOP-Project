/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package x.credit.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import org.w3c.dom.Text;

/**
 *
 * @author rolas
 */
public class User implements Serializable{
    
    private String id;
    private String nome;
    private String apelido;
    private String email;
    private String telefone;
    private String userName;
    private String biografia;
    private String senha;
    private BigDecimal saldo;
//    private BigDecimal saldoTotal;

    public User(String nome, String apelido, String email, String telefone, String userName, String biografia, String senha, BigDecimal saldo) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.userName = userName;
        this.biografia = biografia;
        this.senha = senha;
        this.saldo = saldo;
    }

    public User(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
    }

    public User() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", apelido=").append(apelido);
        sb.append(", email=").append(email);
        sb.append(", telefone=").append(telefone);
        sb.append(", userName=").append(userName);
        sb.append(", biografia=").append(biografia);
        sb.append(", senha=").append(senha);
        sb.append(", saldo=").append(saldo);
        sb.append("}\n");
        return sb.toString();
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

//    @Override
//    public String toString() {
//        return "User{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", email=" + email + ", telefone=" + telefone + ", userName=" + userName + ", biografia=" + biografia + ", senha=" + senha + "}\n";
//    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
