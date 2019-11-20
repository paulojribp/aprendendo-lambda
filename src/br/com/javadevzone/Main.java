package br.com.javadevzone;

import br.com.javadevzone.modelo.Usuario;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario("Jose Silva", 10));
        usuarios.add(new Usuario("Pedro Cabral", 25));
        usuarios.add(new Usuario("Reebrtv", 450));
        usuarios.add(new Usuario("Zebulu", 10));
        usuarios.add(new Usuario("Luanslf", 10));
        usuarios.add(new Usuario("Josue da Costa", 320));
        usuarios.add(new Usuario("Henrique Silva", 500));
    }

    public static void main(String[] args) {
        maisSobreStreams();
    }

    private static void maisSobreStreams() {
        List<Usuario> usuariosFiltrados = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());

        Stream<Usuario> peek = usuarios.stream()
                .filter(u -> u.getPontos() > 100).peek(System.out::println);

        System.out.println("Antes do GET!");
        peek.findAny().get();
        System.out.println("Depois do GET!" + "\n");

        int soma = usuarios.stream().mapToInt(Usuario::getPontos).sum();

        IntBinaryOperator operator = (a, b) -> a + b;
        int novaSoma = usuarios.stream().mapToInt(Usuario::getPontos).reduce(0, Math::max);

        System.out.println(soma + " X " + novaSoma);

        usuarios.stream().iterator().forEachRemaining(System.out::println);
    }

    private static void usandoOptionalEStream() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jose Silva", 10));
        usuarios.add(new Usuario("Pedro Cabral", 25));
        usuarios.add(new Usuario("Reebrtv", 450));
        usuarios.add(new Usuario("Zebulu", 10));
        usuarios.add(new Usuario("Qyuaklqyuer", 10));
        usuarios.add(new Usuario("Josue da Costa", 320));
        usuarios.add(new Usuario("Henrique Silva", 500));

        OptionalDouble average = usuarios.stream().mapToInt(Usuario::getPontos).average();
        System.out.println("Soma de todos os pontos: " + average.orElse(0.0));

        Optional<String> nome = usuarios.stream().max(Comparator.comparing(Usuario::getPontos)).map(Usuario::getNome);
        System.out.println(nome.get());

        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(Usuario::tornarModerador);
        usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getPontos).reversed()));
    }

    private static void ordenandoUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jose Silva", 10));
        usuarios.add(new Usuario("Pedro Cabral", 25));
        usuarios.add(new Usuario("Reebrtv", 450));
        usuarios.add(new Usuario("Zebulu", 10));
        usuarios.add(new Usuario("Qyuaklqyuer", 10));
        usuarios.add(new Usuario("Josue da Costa", 320));
        usuarios.add(new Usuario("Henrique Silva", 500));

        usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getPontos).reversed()));

        Usuario u = new Usuario("Paulo Junior", 15);
        BiFunction<String, Integer, Usuario> supplier = Usuario::new;
        Usuario u2 = supplier.apply("Tiga1", 30);

        System.out.println(u2);

        Validador valida = u::isModerador;
        valida.valida();
        System.out.println(u);

        usuarios.forEach(System.out::println);
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
