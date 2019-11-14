package br.com.javadevzone;

import br.com.javadevzone.modelo.Usuario;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        ordenandoUsuarios();
    }

    private static void ordenandoUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jose Silva", 10));
        usuarios.add(new Usuario("Pedro Cabral", 25));
        usuarios.add(null);
        usuarios.add(new Usuario("Teste", 450));
        usuarios.add(new Usuario("Zebulu", 10));
        usuarios.add(new Usuario("Qyuaklqyuer", 10));
        usuarios.add(new Usuario("Josue da Costa", 32));
        usuarios.add(new Usuario("Henrique Silva", 10));

        usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getNome).reversed()));

        Usuario u = new Usuario("Paulo Junior", 15);
        BiFunction<String, Integer, Usuario> supplier = Usuario::new;
        Usuario u2 = supplier.apply("Tiga1", 30);

        System.out.println(u2);

        Validador valida = u::isModerador;
        valida.valida();
        System.out.println(u);

        //usuarios.forEach(System.out::println);

        //List<String> tickets = Arrays.asList("PETR4", "VALE3", "ITUB4");
        //tickets.forEach(s -> System.out.println(s));
    }

    public static void runnable() {
        List<Integer> numeros = new ArrayList<>();
        for (int x = 0; x < 100000; x++) {
            numeros.add(x);
        }

        int numeroMagico = 5410;

        new Thread(() -> System.out.println(numeroMagico)).start();
        //numeroMagico += numeroMagico ^3;

        System.out.println("Finalizado!");
    }

    private static void imprimeUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usr2 = new Usuario("Pedro Cabral", 25);
        usr2.tornarModerador();
        usuarios.add(usr2);

        usuarios.add(new Usuario("Teste", 450));
        usuarios.add(new Usuario("Jose Silva", 10));
        usuarios.add(new Usuario("Josue da Costa", 32));


        usuarios.removeIf(u -> u.isModerador());

        Consumer<Usuario> mostraMesagem = u -> {
            System.out.println(u.getNome());
        };
        Consumer<Usuario> imprimeNome = u -> {
            System.out.println("Java DevZone");
        };

        usuarios.forEach(mostraMesagem.andThen(imprimeNome));
    }
}
