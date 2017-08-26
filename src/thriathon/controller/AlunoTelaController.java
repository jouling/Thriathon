package thriathon.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import thriathon.model.Aluno;
import thriathon.model.AlunoDados;
import thriathon.view.AlunoTela;

/**
 * @author Eduardo
 */
public class AlunoTelaController {
    AlunoTela tela;
    static List<Aluno> alunos;

    public AlunoTelaController() {
        alunos = new ArrayList<>();
        tela = new AlunoTela();
    }

    public void menuHandle() throws ParseException, FileNotFoundException {
        while (true) {
            switch (AlunoTela.entradaMenu()) {
                case 0:
                    Aluno aluno = tela.inclusaoAluno();
            {
                try {
                    AlunoDados alunoDados = new AlunoDados();
                    alunoDados.gravarArquivo(aluno);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
                    alunos.add(aluno);
                    break;
                case 1:
                    tela.mostrarDados();
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }
}
