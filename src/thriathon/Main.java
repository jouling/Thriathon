package thriathon;

import java.io.FileNotFoundException;
import java.text.ParseException;
import thriathon.controller.AlunoTelaController;


/**
 * @author Eduardo
 */
public class Main {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        new AlunoTelaController().menuHandle(); 
    }
}
