/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author  kleber
 */
@Table(name = "musica")
@Entity
public class Musica {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Favor preencher o campo de título!")
    @Column(name = "titulo")
    private String titulo;

    @NotBlank(message = "Favor preencher o campo de artista!")
    @Column(name = "artista")
    private String artista;
    
    
    @NotBlank(message = "Favor informar o ano de lançamento!")
    @Column(name = "anoLancamento")
    private String anoLancamento;

    public Musica() {
    }

    public Musica(int id, String titulo, String artista, String anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

   
}
