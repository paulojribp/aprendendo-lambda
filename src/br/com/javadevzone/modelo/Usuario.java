package br.com.javadevzone.modelo;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario() {}

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void tornarModerador() {
        this.moderador = true;
    }

    public String toString() {
        return "Usuario de nome " + this.nome + ", e pontos [" + this.pontos + "] e ele é moderador? " + this.moderador + "!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
