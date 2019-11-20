package br.com.javadevzone;

import br.com.javadevzone.modelo.Grupo;
import br.com.javadevzone.modelo.Usuario;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainFiles {

    public static void main(String [] args) throws IOException {
        usuariosRepetidos();
    }

    private static void usuariosRepetidos() {
        var unip = new Grupo();
        unip.add(new Usuario("DeveSerr", 845));
        unip.add(new Usuario("Reebrtv", 250));

        var palmeirenses = new Grupo();
        palmeirenses.add(new Usuario("MarcoBruno", 110));
        palmeirenses.add(new Usuario("Reebrtv", 250));

        List<Grupo> grupos = Arrays.asList(unip, palmeirenses);

        grupos.stream()
                .flatMap(g -> g.getUsuarios().stream())
                .distinct()
                .forEach(u -> System.out.println(u.getNome()));
    }

    private static void lerPasta() throws IOException {
        var stream = Files.list(Paths.get("./src/br/com/javadevzone"))
                .filter(p -> p.toString().endsWith(".java"))
                .flatMap(p -> lines(p));
        stream.forEach(System.out::println);
    }

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}