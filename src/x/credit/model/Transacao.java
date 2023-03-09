/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package x.credit.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author rolas
 */
public class Transacao implements Serializable{
    private Integer id;
    private String evento;
    private String data;
    private String descricao;
    private Double lucro;
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nTransacao{" + "id=" + id + ", evento=" + evento + ", data=" + data + ", descricao=" + descricao + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public String getEvento() {
        return evento;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getLucro() {
        return lucro;
    }
    
}
