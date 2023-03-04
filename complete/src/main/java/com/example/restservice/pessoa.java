package com.example.restservice;


Table(name = "pessoas")
public class pessoa {
    
    @Id
    private Long id;
    
    private String nome;
    
    private int idade;
    
    (nome = "posicao_fila")
    private int posicaoFila;
    public String getNome() {
        return nome;
      }
      
      public void setNome(String nome) {
        this.nome = nome;
      }
      
      public int getIdade() {
        return idade;
      }
      
      public void setIdade(int idade) {
        this.idade = idade;
      }
      
      public int getPosicaoFila() {
        return posicaoFila;
      }
      
      public void setPosicaoFila(int posicaoFila) {
        this.posicaoFila = posicaoFila;
      }
    
  
}