package br.com.javadevzone.modelo;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private List<Usuario> usuarios = new ArrayList<>();

    public void add(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}
