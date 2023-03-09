/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package x.credit.model;

import java.io.Serializable;

/**
 *
 * @author rolas
 */
public class Recarga implements Serializable{
    private String id;
    private Integer valor;
    private String operadora;
    private Integer quantidadeStock;

    public Recarga(String id, Integer valor, String operadora, Integer quantidadeStock) {
        this.id = id;
        this.valor = valor;
        this.operadora = operadora;
        this.quantidadeStock = quantidadeStock;
    }
    
    public String getId() {
        return id;
    }

    public Integer getValor() {
        return valor;
    }

    public String getOperadora() {
        return operadora;
    }

    public Integer getQuantidadeStock() {
        return quantidadeStock;
    }

    public void setQuantidadeStock(Integer quantidadeStock) {
        this.quantidadeStock = quantidadeStock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nRecarga{");
        sb.append("id=").append(id);
        sb.append(", valor=").append(valor);
        sb.append(", operadora=").append(operadora);
        sb.append(", quantidadeStock=").append(quantidadeStock);
        sb.append('}');
        return sb.toString();
    }

    
}
