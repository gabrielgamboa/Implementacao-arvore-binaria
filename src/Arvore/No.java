// HT3001385    
// GABRIEL DE BARROS GAMBOA
package Arvore;

import Models.Aluno;

public class No {

    private Aluno aluno;
    No esquerda;
    No direita;

    public No(Aluno aluno) {
        this.aluno = aluno;
        this.esquerda = null;
        this.direita = null;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public Aluno getElemento() {
        return aluno;
    }

    public void setElemento(Aluno aluno) {
        this.aluno = aluno;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public boolean folha() {
        return this.esquerda == null && this.direita == null;
    }
    
    public boolean apenasFilhoEsquerda() {
        return this.esquerda != null && this.direita == null;
    }

    public boolean apenasFilhoDireita() {
        return this.esquerda == null && this.direita != null;
    }

    
}

