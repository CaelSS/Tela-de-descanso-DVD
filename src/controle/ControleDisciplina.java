package controle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.Disciplina;

public class ControleDisciplina {

    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public boolean salvar(Disciplina disciplina) {
        try {
            disciplinas.add(disciplina);
            System.out.println(disciplina);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<Disciplina> retornarDadosDisciplina() {
        return disciplinas;
    }

    public void salvarEmArquivo(String caminhoArquivo) {
        try {
            FileWriter arquivo = new FileWriter(caminhoArquivo);
            PrintWriter gravador = new PrintWriter(arquivo);

            for (Disciplina disciplina : disciplinas) {
                gravador.println(" nome:" + disciplina.getNome() +
                                 "\n Codigo da Disciplina: " + disciplina.getCodigoDaDisciplina()+
                                 "\n Professor da Disicplina" +disciplina.getProfDisciplina() +
                                 "\n Numero da Sala" + disciplina.getNumeroSala() +
                                 "\n Horas aula" + disciplina.getHorasAula());
            }

            gravador.close();
            System.out.println("Dados salvos no arquivo: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }
}
