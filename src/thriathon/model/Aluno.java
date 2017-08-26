package thriathon.model;

/**
 * @author Eduardo
 */
public class Aluno {

    private static int cont = 0;
    private int idAluno;
    private String nomeAluno;
    private int idadeAluno;

    public Aluno(String nomeAluno, int idadeAluno) {
        setIdAluno(++cont);
        this.nomeAluno = nomeAluno;
        this.idadeAluno = idadeAluno;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public int getIdadeAluno() {
        return idadeAluno;
    }

    public void setIdadeAluno(int idadeAluno) {
        this.idadeAluno = idadeAluno;
    }

}
