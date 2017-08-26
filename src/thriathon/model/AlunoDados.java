package thriathon.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class AlunoDados {

    static File arq;

    public AlunoDados() throws IOException {
        arq = new File("resources/AlunoDados.txt");
        try {
            if (!arq.exists()) {
                FileWriter gravador;
                gravador = new FileWriter("resources/AlunoDados.txt");
                PrintWriter gravar = new PrintWriter(gravador);
                gravar.print("");
                gravar.close();
                gravador.close();
            }
        } catch (IOException ex) {
            new File("resources").mkdir();
                FileWriter gravador;
                gravador = new FileWriter("resources/AlunoDados.txt");
                PrintWriter gravar = new PrintWriter(gravador);
                gravar.print("");
                gravar.close();
                gravador.close(); 
        }

    }

    public static ArrayList <Aluno> lerArquivo() throws FileNotFoundException {
        File file = new File("resources/AlunoDados.txt");
        ArrayList <Aluno> listaAlunos = new ArrayList <>();
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String[] texto = scanner.nextLine().split(";");
            Aluno aluno = new Aluno(texto[1], Integer.parseInt(texto[2]));
            aluno.setIdAluno(Integer.parseInt(texto[0]));
            listaAlunos.add(aluno);
        }
        return listaAlunos;
    }
    public static void gravarArquivo(Aluno aluno) throws IOException {
        try {
            File file = new File("resources/AlunoDados.txt");

            String id = Integer.toString(aluno.getIdAluno()) + ";";
            String nome = aluno.getNomeAluno() + ";";
            String idade = Integer.toString(aluno.getIdadeAluno()) + "\n";
            String texto = id + nome + idade;

            Files.write(Paths.get(file.getPath()), texto.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
