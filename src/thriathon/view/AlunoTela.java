package thriathon.view;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import thriathon.model.Aluno;
import thriathon.model.AlunoDados;
import thriathon.model.AlunoVerificador;

/**
 * @author Eduardo
 */
public class AlunoTela {
    static String texto = "";
    
    public static int entradaMenu() {
        return JOptionPane.showOptionDialog(null, "Escolha a opção desejada: ", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                new String[]{"Cadastrar aluno", "Verificar alunos", "Sair"}, "default");
    }

    public static Aluno inclusaoAluno() throws ParseException {
        
        
        JTextField nomeCampo = new JTextField();
        JTextField idadeCampo = new JTextField();

        Object[] componentes = {
            "Nome", nomeCampo,
            "Idade", idadeCampo};


        int option;
        String textoErro;
        while (true) {
            option = JOptionPane.showConfirmDialog(null, componentes, "Cadastrar Aluno", JOptionPane.CANCEL_OPTION);
            textoErro = "";
            
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher match = pattern.matcher(idadeCampo.getText());
            
            if (option == JOptionPane.CANCEL_OPTION) {
                System.exit(0);
            } else {
                if (nomeCampo.getText().isEmpty()) {
                    textoErro += "Preencha o campo \"Nome\" \n";
                }
                else if (!nomeCampo.getText().matches("[a-zA-Z\\s]+")){
                    textoErro += "Nome inválido. Insira somente letras \n";
                }
                if (idadeCampo.getText().isEmpty()) {
                    textoErro += "Preencha o campo \"Idade\" \n";
                } 
                else if (!match.find()){
                    textoErro += "Idade inválida. Insira somente números \n";
                }
                else if (AlunoVerificador.verificarIdade(Integer.parseInt(idadeCampo.getText()))) {
                    textoErro += "Idade inválida. Deve ser maior que 18 anos para se cadastrar \n";
                }
                if (textoErro.equals("")){
                    break;
                }
                else{
                JOptionPane.showMessageDialog(null, textoErro, "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return new Aluno(nomeCampo.getText(), Integer.parseInt(idadeCampo.getText()));
    }
    
    public void mostrarDados() throws FileNotFoundException{
       List<Aluno> alunos = AlunoDados.lerArquivo();
           texto = ""; 
           alunos.forEach(n -> {
           texto += "ID do Aluno: "+n.getIdAluno() + 
                   "\nNome do Aluno: " + n.getNomeAluno() + 
                   "\nIdade do Aluno: "+n.getIdadeAluno()+
                   "\n----------------------------------------------------------------------------\n";
               });
       JOptionPane.showMessageDialog(null, texto, "Verificar Alunos", JOptionPane.PLAIN_MESSAGE);
    }

}
