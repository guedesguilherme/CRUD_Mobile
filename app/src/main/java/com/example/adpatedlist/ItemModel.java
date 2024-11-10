package com.example.adpatedlist;  // Verifique se este é o pacote correto

public class ItemModel {
    private int imagem;  // Para armazenar o ID da imagem (referência de recurso)
    private String texto;
    private String valor;

    // Construtor
    public ItemModel(int imagem, String texto, String valor) {
        this.imagem = imagem;
        this.texto = texto;
        this.valor = valor;
    }

    // Getters
    public int getImagem() {  // Alterado para int, pois é o tipo correto para o ID da imagem
        return imagem;
    }

    public String getTexto() {
        return texto;
    }

    public String getValor() {
        return valor;
    }
}
