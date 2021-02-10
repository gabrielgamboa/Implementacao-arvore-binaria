//HT3001385
//GABRIEL DE BARROS GAMBÔA

package Models;

public class Aluno {
    private String nome;
    private String curso;
    private int prontuario;

    public Aluno(String nome, int prontuario, String curso) {
        this.nome = nome;
        this.prontuario = prontuario;
        this.curso = curso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProntuario() {
        return this.prontuario;
    }

    public void setProntuario(int prontuario) {
        this.prontuario = prontuario;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
